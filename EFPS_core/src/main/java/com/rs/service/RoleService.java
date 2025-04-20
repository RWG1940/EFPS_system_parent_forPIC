package com.rs.service;

import com.rs.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.exception.pojo.vo.ResultResponse;

/**
* @author RWG
* @description 针对表【role】的数据库操作Service
* @createDate 2024-08-09 21:12:21
*/
public interface RoleService extends IService<Role> {


    ResultResponse getAllRoles();

    ResultResponse addRole(Role role);

    ResultResponse deleteRole(Integer id);

    ResultResponse updateRole(Role role);
}
