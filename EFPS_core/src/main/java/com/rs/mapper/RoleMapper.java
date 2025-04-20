package com.rs.mapper;

import com.rs.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【role】的数据库操作Mapper
* @createDate 2024-08-09 21:12:21
* @Entity com.rs.domain.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    Role findRoleByEmpId(Integer id);

    List<Role> getAllRoles();
}




