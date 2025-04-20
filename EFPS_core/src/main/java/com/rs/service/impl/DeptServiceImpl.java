package com.rs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rs.domain.*;
import com.rs.domain.DeptCount;
import com.rs.domain.PageBean;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.utils.TimeUtil;
import com.rs.service.DeptService;
import com.rs.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author RWG
 * @description 针对表【dept】的数据库操作Service实现
 * @createDate 2024-07-28 12:03:30
 */
@Slf4j
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
        implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private TimeUtil timeUtil;

    @Override
    public ResultResponse getAllDepts() {
        List<Dept> d = deptMapper.getAllDepts();
        if (d == null){
            throw new BizException(ExceptionEnum.NOT_FOUND,"暂无数据");
        }
        return ResultResponse.success(d);
    }

    @Override
    public ResultResponse getDepts(Dept dept) {
        List<Dept> d = deptMapper.getDepts(dept);
        if (d == null){
            throw new BizException(ExceptionEnum.NOT_FOUND,"暂无数据");
        }
        return ResultResponse.success(d);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Dept> d = deptMapper.getAllDepts();
        Page<Dept> p = (Page<Dept>) d;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public ResultResponse getDept(Dept dept) {
        Dept d = deptMapper.getDept(dept);
        if (d == null){
            throw new BizException(ExceptionEnum.NOT_FOUND,"暂无数据");
        }
        return ResultResponse.success(d);
    }

    @Override
    public ResultResponse createDept(Dept dept) {
        dept.setdTotal(0);
        dept.setdUpdatetime(timeUtil.getCurrentTimestamp());
        dept.setdCreatetime(timeUtil.getCurrentTimestamp());
        if (deptMapper.createDept(dept) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"创建失败");
        }
        return ResultResponse.success();
    }

    @Override
    public ResultResponse updateDept(Dept dept) {
        dept.setdUpdatetime(timeUtil.getCurrentTimestamp());
        if (deptMapper.updateDept(dept) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"更新失败");
        }
        return ResultResponse.success();
    }

    @Override
    public ResultResponse deleteDept(Integer id) {
        if (deptMapper.deleteDept(id) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"删除失败");
        }
        return ResultResponse.success();
    }

    @Override
    public ResultResponse deleteDepts(List<Integer> ids) {
        if (deptMapper.deleteDepts(ids) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"删除失败");
        }
        return ResultResponse.success();
    }

    @Override
    public ResultResponse getPages(Integer page, Integer pageSize) {
        // 更新部门所对应的部门人数
        try {
            // 从user表中统计各个dept_id的count值
            List<DeptCount> results = deptMapper.findDeptIdCount();
            if (results != null) {
                Dept dept = new Dept();
                for (DeptCount result : results) {
                    Integer deptId = result.getEDeptId();
                    Integer count = result.getDTotal();
                    dept.setId(deptId);
                    Dept fetchedDept = deptMapper.getDept(dept);
                    if (fetchedDept != null) {
                        fetchedDept.setdTotal(count);
                        updateDept(fetchedDept);
                    } else {
                        log.warn("部门ID {} 未找到对应的部门信息", deptId);
                    }
                }
            } else {
                log.warn("没有找到任何部门信息");
            }
        } catch (Exception e) {
            log.error("处理部门计数时发生错误: ",e);
        }
        PageBean pageBean = page(page, pageSize);
        if (pageBean == null){
            throw new BizException(ExceptionEnum.NOT_FOUND,"暂无数据");
        }
        return ResultResponse.success(pageBean);
    }
}




