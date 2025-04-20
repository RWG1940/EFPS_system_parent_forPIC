package com.rs.controller.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.domain.PageBean;
import com.rs.exception.pojo.vo.ResultResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
public class BaseController<T, S extends IService<T>> {


  @Setter
  private  Class<T> entityClass;

  @Setter
  protected S service;

  public BaseController(S service, Class<T> entityClass) {
    this.service = service;
    this.entityClass = entityClass;
  }

  @GetMapping
  public ResultResponse listAll() {
    return ResultResponse.success(service.list());
  }

  @GetMapping("/pages")
  public ResultResponse getPages(@RequestParam Integer page, @RequestParam Integer pageSize) {
    IPage<T> resultPage = new Page<>(page, pageSize);
    return ResultResponse.success(new PageBean(service.page(resultPage).getTotal(), service.page(resultPage).getRecords()));
  }

  @PostMapping
  public ResultResponse add(@RequestBody T entity) {
    boolean success = service.save(entity);
    String entityName = entityClass.getSimpleName();
    return success ? ResultResponse.success("添加成功") : ResultResponse.error("添加失败");
  }

  @DeleteMapping
  public ResultResponse delete(@RequestParam List<Long> ids) {
    boolean success = service.removeByIds(ids);
    // 获取T的名称
    String entityName = entityClass.getSimpleName();
    return success ? ResultResponse.success("删除成功") : ResultResponse.error("删除失败");
  }

  @PutMapping
  public ResultResponse update(@RequestBody T entity) {
    log.info("Update entity: {}", entity);
    boolean success = service.updateById(entity);
    String entityName = entityClass.getSimpleName();
    return success ? ResultResponse.success("更新成功") : ResultResponse.error("更新失败");
  }

  @PostMapping("/search")
  public ResultResponse search(@RequestBody T entity) {
    QueryWrapper<T> queryWrapper = new QueryWrapper<>();
    log.info("Search entity: {}", entity);

    // 遍历实体类字段
    for (Field field : entity.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      try {
        // 排除 serialVersionUID 字段
        if ("serialVersionUID".equals(field.getName())) {
          continue;
        }

        Object value = field.get(entity);
        if (value != null && !value.toString().isEmpty()) {
          // 获取数据库字段名，处理驼峰转换为下划线
          String fieldName = field.getName();
          String columnName = convertToUnderscore(fieldName);  // 将驼峰字段转换为下划线格式

          // 添加模糊查询条件
          queryWrapper.like(columnName, value);
        }
      } catch (IllegalAccessException e) {
        log.error("Field access error: ", e);
      }
    }

    List<T> result = service.list(queryWrapper);
    return result != null ? ResultResponse.success(result) : ResultResponse.error("查询失败");
  }

  // 方法：将驼峰命名转换为下划线命名
  private String convertToUnderscore(String camelCase) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < camelCase.length(); i++) {
      char c = camelCase.charAt(i);
      if (Character.isUpperCase(c)) {
        if (i > 0) {
          result.append('_');  // 添加下划线分隔符
        }
        result.append(Character.toLowerCase(c));  // 转换为小写字母
      } else {
        result.append(c);
      }
    }
    return result.toString();
  }

}
