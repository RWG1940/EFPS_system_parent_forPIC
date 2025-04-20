package com.rs.controller;

import com.rs.domain.dto.EmpRoleDeptDTO;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @FileName: LoginController
 * @Date: 2024/7/27:22:01
 * @Description: 登录控制器
 * @Author: RWG
 */
@RestController
@Slf4j
@RequestMapping("/login")
@Api(tags = "登录控制器")
public class LoginController {
    @Autowired
    private EmpService empService;

    // 账号密码登录
    @PostMapping
    @ApiOperation("账号密码登录")
    public ResultResponse login(@RequestBody EmpRoleDeptDTO erdd) {
        return empService.login(erdd);
    }

    // 功能：1.自动登录 2.取得登录用户信息
    @PostMapping("/auto-login")
    @ApiOperation("token登录")
    public ResultResponse autoLogin() {
        return empService.loginByToken();
    }
    // 退出登录
    @PostMapping("/logout")
    @ApiOperation("退出登录")
    public ResultResponse logout() {
        return empService.logout();
    }

}
