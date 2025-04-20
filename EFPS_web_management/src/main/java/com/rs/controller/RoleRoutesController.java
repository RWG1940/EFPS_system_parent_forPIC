package com.rs.controller;

import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.RoleRoutesService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: 角色路由控制器 @Author: RWG @Date: 2024/10/20:10:45
 */
@RestController
@Slf4j
@RequestMapping("/roleRoutes")
@Api(tags = "角色路由控制器")
@PreAuthorize("hasAuthority('admin')")
public class RoleRoutesController {
  @Autowired private RoleRoutesService roleRoutesService;

  @GetMapping("/{rId}")
  public ResultResponse getAllRoleRoutes(@PathVariable("rId") Integer rId) {
    return roleRoutesService.getAllRoleRoutes(rId);
  }

  @PostMapping()
  public ResultResponse addRoleRoutes(@RequestBody Map<String, Object> requestData) {
    Integer rId = (Integer) requestData.get("rId");
    List<Integer> roIdList = (List<Integer>) requestData.get("roId");
    return roleRoutesService.addRoleRoutes(rId, roIdList);
  }

  @DeleteMapping("/{id}")
  public ResultResponse deleteRoleRoutes(@PathVariable("id") Integer id) {
    return roleRoutesService.deleteRoleRoutes(id);
  }
}
