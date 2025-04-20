package com.rs.controller;

import com.rs.domain.DynamicRoutes;
import com.rs.domain.Menu;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 权限控制器
 * @Author: RWG
 * @Date: 2024/10/28:21:17
 */
@RestController
@Slf4j
@RequestMapping("/permission")
@Api(tags = "权限控制器")
@PreAuthorize("hasAuthority('admin')")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/pages")
    @ApiOperation("获取分页数据")
    public ResultResponse getPages(@RequestParam Integer page,
                                   @RequestParam Integer pageSize) {
        return menuService.getPages(page, pageSize);
    }

    @PostMapping("/search")
    @ApiOperation("按条件获取权限列表")
    public ResultResponse getPermissions(@RequestBody Menu menu) {
        return menuService.getPermissions(menu);
    }

    @GetMapping()
    @ApiOperation("获取所有权限")
    public ResultResponse getAllPermissions() {
        return menuService.getAllPermissions();
    }

    @DeleteMapping
    @ApiOperation("删除权限")
    public ResultResponse deletePermissions(@RequestParam Integer[] ids) {
        return menuService.deletePermissions(ids);
    }

    @PostMapping
    @ApiOperation("添加权限")
    public ResultResponse addPermissions(@RequestBody Menu menu) {
        return menuService.addPermissions(menu);
    }


    @PutMapping
    @ApiOperation("更新路由项")
    public ResultResponse updatePermissions(@RequestBody Menu menu) {
        return menuService.updatePermissions(menu);
    }

}
