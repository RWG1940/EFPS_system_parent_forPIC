package com.rs.controller;

import com.rs.domain.DynamicRoutes;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.DynamicRoutesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: RWG
 * @Date: 2024/10/9:16:08
 */
@RestController
@Slf4j
@RequestMapping("/dynamic-route")
@Api(tags = "动态路由控制器")
public class DynamicRoutesController {
    @Autowired
    private DynamicRoutesService dynamicRoutesService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/pages")
    @ApiOperation("获取分页数据")
    public ResultResponse getPages(@RequestParam Integer page,
                                   @RequestParam Integer pageSize) {
        return dynamicRoutesService.getPages(page, pageSize);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/search")
    @ApiOperation("按条件获取路由列表")
    public ResultResponse getRoutes(@RequestBody DynamicRoutes route) {
        return dynamicRoutesService.getRoutes(route);
    }

    @PreAuthorize("hasAuthority('emp')")
    @GetMapping()
    @ApiOperation("获取所有路由项")
    public ResultResponse getAllRoutes() {
        return dynamicRoutesService.getAllRoutes();
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping
    @ApiOperation("删除路由项")
    public ResultResponse deleteRoutes(@RequestParam Integer[] ids) {
        return dynamicRoutesService.deleteRoutes(ids);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    @ApiOperation("添加路由项")
    public ResultResponse addRoutes(@RequestBody DynamicRoutes route) {
        return dynamicRoutesService.addRoutes(route);
    }


    @PreAuthorize("hasAuthority('admin')")
    @PutMapping
    @ApiOperation("更新路由项")
    public ResultResponse updateRoutes(@RequestBody DynamicRoutes route) {
        return dynamicRoutesService.updateRoutes(route);
    }


}
