package com.rs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rs.domain.Emp;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.EmpService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: RWG
 * @Date: 2024/12/3:19:05
 */
@RestController
@Slf4j
@Api("找回账户控制器")
@RequestMapping("/foundMe")
public class FoundController {
    @Autowired
    private EmpService empService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PutMapping()
    public ResultResponse foundMe(@RequestBody Emp emp) {
        log.info("找回账户：{}", emp);
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("e_username", emp.geteUsername());
        queryWrapper.eq("e_id", emp.geteId());
        queryWrapper.eq("e_phone",emp.getePhone());
        queryWrapper.eq("e_name",emp.geteName());
        if (empService.getOne(queryWrapper) != null) {
            QueryWrapper<Emp> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("e_username", emp.geteUsername());
            emp.setePassword(passwordEncoder.encode("1234"));
            empService.update(emp, queryWrapper1);
            return ResultResponse.success("找回成功");
        }
        return ResultResponse.error("找回失败");
    }
    @GetMapping()
    public ResultResponse getMe() {
        return ResultResponse.success();
    }
}
