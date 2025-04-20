package com.rs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rs.domain.Role;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.RoleService;
import com.rs.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author RWG
* @description 针对表【role】的数据库操作Service实现
* @createDate 2024-08-09 21:12:21
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public ResultResponse getAllRoles() {
        return ResultResponse.success(roleMapper.getAllRoles());
    }

    @Override
    public ResultResponse addRole(Role role) {
        log.warn(role.toString());
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("r_info",role.getrInfo());
        if (roleMapper.selectOne(queryWrapper) != null){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"该角色已存在");
        }
        if (roleMapper.insert(role) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"添加失败");
        }else{
            return ResultResponse.success();
        }
    }

    @Override
    public ResultResponse deleteRole(Integer id) {
        if (roleMapper.deleteById(id) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"删除失败");
        }else{
            return ResultResponse.success();
        }
    }

    @Override
    public ResultResponse updateRole(Role role) {
        if (roleMapper.updateById(role) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"修改失败");
        }else{
            return ResultResponse.success();
        }
    }
}




