package com.rs.service;

import com.rs.domain.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.domain.dto.EmpRoleDeptDTO;
import com.rs.exception.pojo.vo.ResultResponse;

import java.util.List;

/**
* @author RWG
* @description 针对表【emp】的数据库操作Service
* @createDate 2024-07-26 17:17:57
*/
public interface EmpService extends IService<Emp> {

    ResultResponse getAllEmps();

    ResultResponse createEmp(EmpRoleDeptDTO empRoleDeptDTO);

    ResultResponse updateEmp(EmpRoleDeptDTO empRoleDeptDTO);

    ResultResponse deleteEmp(Integer id);

    ResultResponse getEmps(Emp emp);

    ResultResponse page(Integer page,Integer pageSize);

    ResultResponse deleteEmps(List<Integer> ids);

    ResultResponse login(EmpRoleDeptDTO erdd);

    ResultResponse register(Emp emp);

    ResultResponse loginByToken();

    ResultResponse logout();
}
