package com.rs.controller;

import com.rs.domain.Emp;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @FileName: RegController
 * @Date: 2024/7/28:11:09
 * @Description: 注册控制器
 * @Author: RWG
 */
@RestController
@Slf4j
@RequestMapping("/reg")
@Api(tags = "注册控制器")

public class RegController {
    @Autowired
    private EmpService empService;

    @PostMapping
    @ApiOperation("员工注册")
    public ResultResponse reg(@RequestBody Emp emp) {
        log.info("员工注册：{}", emp.geteUsername());
        return empService.register(emp);
    }
}
