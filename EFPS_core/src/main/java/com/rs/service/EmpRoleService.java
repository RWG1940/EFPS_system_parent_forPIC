package com.rs.service;

import com.rs.domain.EmpRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author RWG
* @description 针对表【emp_role】的数据库操作Service
* @createDate 2024-08-11 19:25:57
*/
public interface EmpRoleService extends IService<EmpRole> {

    void insertEmpRole(int id, int i);

    int updateEmpRole(int id, int getrId);
}
