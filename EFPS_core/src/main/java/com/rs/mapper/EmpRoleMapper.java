package com.rs.mapper;

import com.rs.domain.EmpRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author RWG
* @description 针对表【emp_role】的数据库操作Mapper
* @createDate 2024-08-11 19:25:57
* @Entity com.rs.domain.EmpRole
*/
@Mapper
public interface EmpRoleMapper extends BaseMapper<EmpRole> {

    void insertEmpRole(int id, int i);

    int updateEmpRole(int id, int i);
}




