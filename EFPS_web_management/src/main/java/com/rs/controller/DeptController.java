package com.rs.controller;

import com.rs.domain.*;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @FileName: DeptController
 * @Date: 2024/8/4:14:26
 * @Description: 部门控制器
 * @Author: RWG
 */
@Slf4j
@RestController
@RequestMapping("/depts")
@Api(tags = "部门控制器")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("获取所有部门数据")
    public ResultResponse getAllDepts() {
        return deptService.getAllDepts();
    }

    @PostMapping("/search")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("按条件获取部门列表")
    public ResultResponse getDepts(@RequestBody Dept dept) {
        return deptService.getDepts(dept);
    }

    @GetMapping("/pages")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("获取分页数据")
    public ResultResponse getPages(@RequestParam Integer page,
                                   @RequestParam Integer pageSize) {
        return deptService.getPages(page, pageSize);
    }

    @PostMapping("/dept")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("获取指定字段的部门")
    public ResultResponse getDeptById(@RequestBody Dept dept) {
        return deptService.getDept(dept);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("创建新部门")
    public ResultResponse createDept(@RequestBody Dept dept) {
        return deptService.createDept(dept);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("更新部门信息")
    public ResultResponse updateDept(@RequestBody Dept dept) {
        log.info("dept:{}",dept);
        return deptService.updateDept(dept);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    @ApiOperation("删除指定 ID 的部门")
    public ResultResponse deleteDept(@PathVariable Integer id) {
        return deptService.deleteDept(id);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/batch")
    @ApiOperation("删除部门合集")
    public ResultResponse deleteDepts(@RequestParam List<Integer> ids) {
        return deptService.deleteDepts(ids);
    }

}

