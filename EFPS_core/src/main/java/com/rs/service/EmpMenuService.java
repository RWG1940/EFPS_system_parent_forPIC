package com.rs.service;

import com.rs.domain.EmpMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.exception.pojo.vo.ResultResponse;

import java.util.List;

/**
* @author RWG
* @description 针对表【emp_menu】的数据库操作Service
* @createDate 2024-10-30 20:50:30
*/
public interface EmpMenuService extends IService<EmpMenu> {

    ResultResponse getAllEmpMenu(Integer eId);

    ResultResponse addEmpMenu(Integer eId, List<Integer> mIdList);

    ResultResponse deleteEmpMenu(Integer id);
}
