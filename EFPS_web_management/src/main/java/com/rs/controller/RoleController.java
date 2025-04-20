package com.rs.controller;

import com.rs.domain.Role;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 角色控制器 @Author: RWG @Date: 2024/10/19:12:12
 */
@RestController
@Slf4j
@RequestMapping("/role")
@Api(tags = "角色控制器")
@PreAuthorize("hasAuthority('admin')")
public class RoleController {
  @Autowired private RoleService roleService;

  @GetMapping()
  @ApiOperation("获取所有角色")
  public ResultResponse getAllRoles() {
    return roleService.getAllRoles();
  }

  @PostMapping()
  @ApiOperation("添加角色")
  public ResultResponse addRole(@RequestBody Role role) {
    return roleService.addRole(role);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除角色")
  public ResultResponse deleteRole(@PathVariable("id") Integer id) {
    return roleService.deleteRole(id);
  }

  @PutMapping()
  @ApiOperation("修改角色")
  public ResultResponse updateRole(@RequestBody Role role) {
    return roleService.updateRole(role);
  }
}
