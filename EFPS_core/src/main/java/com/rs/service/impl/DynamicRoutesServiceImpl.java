package com.rs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rs.domain.*;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.mapper.EmpMapper;
import com.rs.mapper.RoleMapper;
import com.rs.mapper.RoleRoutesMapper;
import com.rs.service.DynamicRoutesService;
import com.rs.mapper.DynamicRoutesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RWG
 * @description 针对表【dynamic_routes】的数据库操作Service实现
 * @createDate 2024-10-09 16:07:46
 */
@Slf4j
@Service
public class DynamicRoutesServiceImpl extends ServiceImpl<DynamicRoutesMapper, DynamicRoutes>
    implements DynamicRoutesService {

  @Autowired private EmpMapper empMapper;
  @Autowired private RoleMapper roleMapper;
  @Autowired private RoleRoutesMapper roleRoutesMapper;
  @Autowired private DynamicRoutesMapper dynamicRoutesMapper;

  @Override
  public ResultResponse getPages(Integer page, Integer pageSize) {

    // 启动分页
    PageHelper.startPage(page, pageSize);
    List<DynamicRoutes> dynamicRoutes = dynamicRoutesMapper.getAllRoutes();
    if (dynamicRoutes == null) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "获取数据失败");
    }
    Page<DynamicRoutes> p = (Page<DynamicRoutes>) dynamicRoutes;

    return ResultResponse.success(new PageBean(p.getTotal(), p.getResult()));
  }

  @Override
  public ResultResponse getRoutes(DynamicRoutes route) {
    return ResultResponse.success(dynamicRoutesMapper.getRoutes(route));

  }

  @Override
  public ResultResponse getAllRoutes() {
    // 根据用户角色获取路由
    // 首先取得用户角色（根据header中携带的token）
    UserDetails userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (userDetails != null) {
      Role role =
          roleMapper.findRoleByEmpId(empMapper.getEmp(new Emp(userDetails.getUsername())).getId());
      // 其次获取该角色所拥有的路由
      List<Integer> routeIds = roleRoutesMapper.getRouteIdsByRoleId(role.getrId());
      //System.out.println("该角色所拥有的路由:"+routeIds);
      List<DynamicRoutes> routes = dynamicRoutesMapper.getRoutesByIds(routeIds);
      //System.out.println(routes.toString());
      // 构建路由树
      List<DynamicRoutes> routeTree = buildRouteTree(routes, 0); // 顶级路由的 parentRouteId 为 0
      return ResultResponse.success(routeTree);

    } else {
      throw new BizException(ExceptionEnum.UNAUTHORIZED);
    }
  }

  /**
   * 递归构建路由树
   *
   * @param routes 路由列表
   * @param parentId 父路由ID
   * @return 路由树
   */
  private List<DynamicRoutes> buildRouteTree(List<DynamicRoutes> routes, int parentId) {
    List<DynamicRoutes> tree = new ArrayList<>();
    for (DynamicRoutes route : routes) {
      // 如果当前路由的 parentRouteId 等于 parentId，则它是该层级的路由
      if (route.getParentrouteid() == parentId) {
        // 递归获取子路由
        List<DynamicRoutes> children = buildRouteTree(routes, route.getId());
        route.setChildren(children); // 设置子路由
        tree.add(route);
      }
    }
    return tree;
  }

  @Override
  public ResultResponse deleteRoutes(Integer[] ids) {
    if(dynamicRoutesMapper.deleteBatchIds(Arrays.asList(ids)) == 0){
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "删除失败");
    }else{
      return ResultResponse.success();
    }
  }

  @Override
  public ResultResponse addRoutes(DynamicRoutes route) {
    // 获取当前操作用户的id
    UserDetails userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    route.setCreateuserid(empMapper.getEmp(new Emp(userDetails.getUsername())).getId());
    if(dynamicRoutesMapper.insertRoute(route) == 0){
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "添加失败");
    }else{
      return ResultResponse.success();
    }
  }

  @Override
  public ResultResponse updateRoutes(DynamicRoutes route) {
    if(dynamicRoutesMapper.updateRoute(route) == 0){
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "更新失败");
    }else{
      return ResultResponse.success();
    }
  }
}
