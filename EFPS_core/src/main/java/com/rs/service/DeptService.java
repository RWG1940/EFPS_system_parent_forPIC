package com.rs.service;

import com.rs.domain.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.domain.PageBean;
import com.rs.exception.pojo.vo.ResultResponse;

import java.util.List;

/**
* @author RWG
* @description 针对表【dept】的数据库操作Service
* @createDate 2024-07-28 12:03:30
*/
public interface DeptService extends IService<Dept> {

    ResultResponse getAllDepts();

    ResultResponse getDepts(Dept dept);

    PageBean page(Integer page, Integer pageSize);

    ResultResponse getDept(Dept dept);

    ResultResponse createDept(Dept dept);

    ResultResponse updateDept(Dept dept);

    ResultResponse deleteDept(Integer id);

    ResultResponse deleteDepts(List<Integer> ids);

    ResultResponse getPages(Integer page, Integer pageSize);
}
