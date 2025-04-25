package com.rs.controller;

import com.rs.domain.dto.EmpRoleDeptDTO;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @FileName: EmpController
 * @Date: 2024/7/26:17:21
 * @Description: 职员控制器
 * @Author: RWG
 */
@Slf4j
@RestController
@RequestMapping("/rwg/emps")
@Api(tags = "职员控制器")
public class EmpController {

    @Autowired
    private EmpService empService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping
    @ApiOperation("获取所有员工")
    public ResultResponse getAllEmps() {
        return empService.getAllEmps();
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/pages")
    @ApiOperation("获取分页数据")
    public ResultResponse getPages(@RequestParam Integer page,
                           @RequestParam Integer pageSize) {
        return empService.page(page,pageSize);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/search")
    @ApiOperation("获取指定字段的员工")
    public ResultResponse getEmps(@RequestBody EmpRoleDeptDTO empRoleDeptDTO) {
        return empService.getEmps(empRoleDeptDTO.getEmp());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("创建新员工")
    public ResultResponse createEmp(@RequestBody EmpRoleDeptDTO empRoleDeptDTO) {
        return empService.createEmp(empRoleDeptDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('emp')")
    @ApiOperation("更新员工信息")
    public ResultResponse updateEmp(@RequestBody EmpRoleDeptDTO empRoleDeptDTO) {
        return empService.updateEmp(empRoleDeptDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("删除指定 ID 的员工")
    public ResultResponse deleteEmp(@PathVariable Integer id) {
        return empService.deleteEmp(id);
    }

    @DeleteMapping("/batch")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("删除员工合集")
    public ResultResponse deleteEmps(@RequestParam List<Integer> ids) {
        return empService.deleteEmps(ids);
    }

}
