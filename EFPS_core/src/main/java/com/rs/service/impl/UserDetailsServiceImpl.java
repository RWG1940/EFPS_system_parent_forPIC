package com.rs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rs.domain.Emp;
import com.rs.domain.LoginUserDetail;
import com.rs.exception.pojo.BizException;
import com.rs.mapper.EmpMapper;
import com.rs.mapper.EmpMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @FileName: UserDetailsServiceImpl @Date: 2024/8/7:22:08 @Description: @Author: RWG
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired private EmpMenuMapper empMenuMapper;
  @Autowired private EmpMapper empMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 连接数据库，根据用户名查询用户信息
    QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("e_username", username);
    Emp emp = empMapper.selectOne(queryWrapper);
    if (emp == null) {
      throw new BizException("不存在该用户: " + username);
    }
    // 赋权
    List<String> roles = empMenuMapper.selectRoleList(emp.getId());
    return new LoginUserDetail(emp, roles);
  }
}
