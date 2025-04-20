package com.rs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rs.domain.EmpRole;
import com.rs.service.EmpRoleService;
import com.rs.mapper.EmpRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author RWG
* @description 针对表【emp_role】的数据库操作Service实现
* @createDate 2024-08-11 19:25:57
*/
@Service
public class EmpRoleServiceImpl extends ServiceImpl<EmpRoleMapper, EmpRole>
    implements EmpRoleService{
    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Override
    public void insertEmpRole(int id, int i) {
        empRoleMapper.insertEmpRole(id,i);
    }

    @Override
    public int updateEmpRole(int id, int rId) {
        return empRoleMapper.updateEmpRole(id,rId);
    }
}




