package com.rs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rs.domain.DynamicRoutes;
import com.rs.domain.PageBean;
import com.rs.domain.RoleRoutes;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.RoleRoutesService;
import com.rs.mapper.RoleRoutesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RWG
 * @description 针对表【role_routes】的数据库操作Service实现
 * @createDate 2024-10-09 17:42:55
 */
@Service
public class RoleRoutesServiceImpl extends ServiceImpl<RoleRoutesMapper, RoleRoutes>
    implements RoleRoutesService {

  @Autowired private RoleRoutesMapper roleRoutesMapper;

  @Override
  public ResultResponse getAllRoleRoutes(Integer rId) {
    QueryWrapper<RoleRoutes> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("r_id", rId);
    return ResultResponse.success(roleRoutesMapper.selectList(queryWrapper));
  }

  @Override
  public ResultResponse addRoleRoutes(Integer rId, List<Integer> roIds) {
    // 创建 QueryWrapper，用于检查是否有重复的路由
    QueryWrapper<RoleRoutes> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("r_id", rId).in("ro_id", roIds);

    // 查找是否有重复的路由
    List<RoleRoutes> existingRoutes = roleRoutesMapper.selectList(queryWrapper);
    if (!existingRoutes.isEmpty()) {
      // 获取已存在的路由 ID 列表
      List<Integer> existingRoIds =
          existingRoutes.stream().map(RoleRoutes::getRoId).collect(Collectors.toList());
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "角色已拥有以下路由: " + existingRoIds);
    }

    // 构建需要插入的 RoleRoutes 列表
    List<RoleRoutes> roleRoutesList = new ArrayList<>();
    for (Integer roId : roIds) {
      RoleRoutes roleRoute = new RoleRoutes();
      roleRoute.setrId(rId);
      roleRoute.setRoId(roId);
      roleRoutesList.add(roleRoute);
    }

    // 批量插入
    int insertCount = roleRoutesMapper.insertBatch(roleRoutesList);
    if (insertCount == 0) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "批量添加失败");
    } else {
      return ResultResponse.success();
    }
  }

  @Override
  public ResultResponse deleteRoleRoutes(Integer id) {
    if (roleRoutesMapper.deleteById(id) == 0) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "删除失败");
    } else {
      return ResultResponse.success();
    }
  }
}
