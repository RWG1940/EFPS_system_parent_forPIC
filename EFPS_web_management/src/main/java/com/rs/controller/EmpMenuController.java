package com.rs.controller;

import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.EmpMenuService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: 角色路由控制器
 * @Author: RWG
 * @Date: 2024/10/20:10:45
 */
@RestController
@Slf4j
@RequestMapping("/empPermission")
@Api(tags = "角色权限控制器")
@PreAuthorize("hasAuthority('admin')")
public class EmpMenuController {
    @Autowired
    private EmpMenuService empMenuService;

    @GetMapping("/{eId}")
    public ResultResponse getAllEmpMenu(@PathVariable("eId") Integer eId) {
        return empMenuService.getAllEmpMenu(eId);
    }

    @PostMapping()
    public ResultResponse addEmpMenu(@RequestBody Map<String, Object> requestData) {
        Integer eId = (Integer) requestData.get("eId");
        List<Integer> mIdList = (List<Integer>) requestData.get("mId");
        return empMenuService.addEmpMenu(eId, mIdList);
    }


    @DeleteMapping("/{id}")
    public ResultResponse deleteEmpMenu(@PathVariable("id") Integer id) {
        return empMenuService.deleteEmpMenu(id);
    }

}
