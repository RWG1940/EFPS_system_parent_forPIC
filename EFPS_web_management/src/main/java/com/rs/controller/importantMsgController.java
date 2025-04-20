package com.rs.controller;

import com.rs.domain.ImportantMsg;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.ImportantMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @FileName: importantMsgController
 * @Date: 2024/9/3:14:54
 * @Description: 重要通知控制器
 * @Author: RWG
 */
@RestController
@Slf4j
@RequestMapping("/notices")
@Api(tags = "重要通知控制器")
public class importantMsgController {
    @Autowired
    private ImportantMsgService importantMsgService;

    //获取所有消息
    @GetMapping
    @PreAuthorize("hasAuthority('emp')")
    @ApiOperation("获取所有消息")
    public ResultResponse getAllImportantMsgs() {
        return importantMsgService.getImportantMsgs();
    }

    //获取分页消息
    @GetMapping("/pages")
    @PreAuthorize("hasAuthority('emp')")
    @ApiOperation("获取分页消息")
    public ResultResponse getPages(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return importantMsgService.getPages(page, pageSize);
    }

    //搜索消息
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('emp')")
    @ApiOperation("搜索消息")
    public ResultResponse searchImportantMsgs(@RequestBody ImportantMsg importantMsg) {
        return importantMsgService.searchImportantMsgs(importantMsg);
    }

    //添加消息
    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("添加消息")
    public ResultResponse addImportantMsgs(@RequestBody ImportantMsg importantMsg) {
        log.info(importantMsg.toString());
        return importantMsgService.addImportantMsgs(importantMsg);
    }

    //更新消息
    @PutMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("更新消息")
    public ResultResponse updateImportantMsgs(@RequestBody ImportantMsg importantMsg) {
        return importantMsgService.updateImportantMsgs(importantMsg);
    }


    //批量删除消息
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation("批量删除消息")
    public ResultResponse deleteBatchImportantMsgs(@RequestParam List<Integer> ids) {
        return importantMsgService.deleteBatchImportantMsgs(ids);
    }


}
