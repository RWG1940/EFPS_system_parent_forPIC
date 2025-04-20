package com.rs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rs.domain.*;
import com.rs.domain.dto.EmpRoleDeptDTO;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.mapper.DeptMapper;
import com.rs.mapper.RoleMapper;
import com.rs.service.EmpMenuService;
import com.rs.service.EmpRoleService;
import com.rs.service.EmpService;
import com.rs.mapper.EmpMapper;
import com.rs.service.MenuService;
import com.rs.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rs.utils.TimeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RWG
 * @description 针对表【emp】的数据库操作Service实现
 * @createDate 2024-07-26 17:17:57
 */
@Slf4j
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

  @Autowired private EmpMapper empMapper;
  @Autowired private AuthenticationManager authenticationManager;
  @Autowired private TimeUtil timeUtil;
  @Autowired private PasswordEncoder passwordEncoder;
  @Autowired private EmpRoleService empRoleService;
  @Autowired private MenuService menuService;
  @Autowired private EmpMenuService empMenuService;
  @Autowired private RoleMapper roleMapper;
  @Autowired private DeptMapper deptMapper;


  @Override
  public ResultResponse getAllEmps() {
    List<Emp> emps = empMapper.getAllEmps();
    if (emps == null) {
      throw new BizException(ExceptionEnum.NOT_FOUND, "没有找到任何员工");
    }
    List<EmpRoleDeptDTO> empRoleDTOs = new ArrayList<>();
    for (Emp e : emps) {
      int isOnline = 1;
      empRoleDTOs.add(
          new EmpRoleDeptDTO(
              e,
              roleMapper.findRoleByEmpId(e.getId()),
              deptMapper.getDept(new Dept(e.geteDeptid())),
              isOnline));
    }
    return ResultResponse.success(empRoleDTOs);
  }

  @Override
  public ResultResponse createEmp(EmpRoleDeptDTO empRoleDeptDTO) {
    Emp emp = empRoleDeptDTO.getEmp();
    System.out.println(empRoleDeptDTO);
    // 查找用户是否已存在
    if (empMapper.getEmp(new Emp(emp.geteUsername())) != null) {
      throw new BizException(ExceptionEnum.CONFLICT, "用户已存在");
    }
    // 加密密码
    emp.setePassword(passwordEncoder.encode(emp.getePassword()));
    // 插入数据
    if (empMapper.createEmp(emp) != 1) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "创建用户失败");
    }
    // 重新构建emp实体 查找创建后的emp实体
    Emp e = new Emp();
    e.seteUsername(emp.geteUsername());
    e.setePassword(emp.getePassword());
    Emp new_e = empMapper.getEmp(e);
    // 设置创建时间和更新时间
    new_e.seteUpdatetime(timeUtil.getCurrentTimestamp());
    new_e.seteCreatetime(timeUtil.getCurrentTimestamp());
    empMapper.updateEmp(new_e);
    // 赋予初始角色
    empRoleService.insertEmpRole(new_e.getId(), empRoleDeptDTO.getRole().getrId());
    return ResultResponse.success();
  }

  @Override
  public ResultResponse updateEmp(EmpRoleDeptDTO empRoleDeptDTO) {
    Emp emp = empRoleDeptDTO.getEmp();
    if ("N".equals(emp.getePassword())) {
      emp.setePassword(null);
    } else {
      if (emp.getePassword() != null) {
        emp.setePassword(passwordEncoder.encode(emp.getePassword()));
      }
    }

    emp.seteUpdatetime(timeUtil.getCurrentTimestamp());
    // 更新员工
    if (empMapper.updateEmp(emp) == 0) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "更新用户失败");
    }
    // 更新角色
    if (empRoleDeptDTO.getRole().getrId() != null) {
      empRoleService.updateEmpRole(emp.getId(), empRoleDeptDTO.getRole().getrId());
    }
    return ResultResponse.success();
  }

  @Override
  public ResultResponse deleteEmp(Integer id) {
    if (empMapper.deleteEmp(id) == 0) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "删除用户失败");
    }

    return ResultResponse.success();
  }

  @Override
  public ResultResponse getEmps(Emp emp) {
    List<Emp> emps = empMapper.getEmps(emp);
    if (emps == null) {
      throw new BizException(ExceptionEnum.NOT_FOUND, "没有找到任何员工");
    }
    List<EmpRoleDeptDTO> empRoleDTOs = new ArrayList<>();
    for (Emp e : emps) {
      int isOnline = 1;
      empRoleDTOs.add(
          new EmpRoleDeptDTO(
              e,
              roleMapper.findRoleByEmpId(e.getId()),
              deptMapper.getDept(new Dept(e.geteDeptid())),
              isOnline));
    }
    return ResultResponse.success(empRoleDTOs);
  }

  @Override
  public ResultResponse page(Integer page, Integer pageSize) {
    // 开始分页
    PageHelper.startPage(page, pageSize);
    // 查询所有员工
    List<Emp> emps = empMapper.getAllEmps();
    // 创建 PageInfo 对象来获取分页信息
    PageInfo<Emp> pageInfo = new PageInfo<>(emps);
    // 构建包含员工和角色的 DTO 列表
    List<EmpRoleDeptDTO> empRoleDTOs = new ArrayList<>();
    for (Emp emp : emps) {
      int isOnline = 1;
      empRoleDTOs.add(
          new EmpRoleDeptDTO(
              emp,
              roleMapper.findRoleByEmpId(emp.getId()),
              deptMapper.getDept(new Dept(emp.geteDeptid())),
              isOnline));
    }
    // 构建新的分页对象
    PageInfo<EmpRoleDeptDTO> resultPage = new PageInfo<>(empRoleDTOs);
    resultPage.setTotal(pageInfo.getTotal());

    return ResultResponse.success(new PageBean(resultPage.getTotal(), resultPage.getList()));
  }

  @Override
  public ResultResponse deleteEmps(List<Integer> ids) {
    if (empMapper.deleteEmps(ids) == 0) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "删除用户失败");
    }
    return ResultResponse.success();
  }

  @Override
  public ResultResponse login(EmpRoleDeptDTO erdd) {

    // 创建认证对象
    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(
            erdd.getEmp().geteUsername(), erdd.getEmp().getePassword());
    // 执行认证
    try {
      Authentication authenticate = authenticationManager.authenticate(authentication);
      // 获取认证成功后的用户信息
      LoginUserDetail loginUserDetail = (LoginUserDetail) authenticate.getPrincipal();
      // 检查是否被禁用
      if (loginUserDetail.getEmp().geteIsenabled() == 0) {
        return ResultResponse.error("该用户已被禁用，请联系管理员");
      }

      if (erdd.isRememberMe()) {
        log.info("账户：" + erdd.getEmp().geteUsername() + "，通过账号密码登录，记住密码7天");
        return ResultResponse.success(
            JwtUtils.generateJwtFromJson(
                JSON.toJSONString(loginUserDetail), (long) (60 * 60 * 24 * 7 * 1000)));
      } else {
        log.info("账户：" + erdd.getEmp().geteUsername() + "，通过账号密码登录");
        return ResultResponse.success(
            JwtUtils.generateJwtFromJson(JSON.toJSONString(loginUserDetail), null));
      }

    } catch (Exception e) {
      throw new BizException(ExceptionEnum.UNAUTHORIZED, "用户名或密码错误");
    }
  }

  @Override
  public ResultResponse register(Emp emp) {
    // 查找用户是否已存在
    try {
      Emp existingEmp = new Emp();
      existingEmp.seteUsername(emp.geteUsername());
      Emp foundEmp = empMapper.getEmp(existingEmp);
      if (foundEmp != null) {
        throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "用户已存在");
      }
    } catch (Exception e) {
      if (!(e instanceof BizException)) {
        log.error("查询用户时发生错误", e);
        throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "系统错误");
      }
      throw e;
    }

    try {
      // 加密密码
      emp.setePassword(passwordEncoder.encode(emp.getePassword()));
      // 设置临时部门
      emp.seteDeptid(49);
      // 设置启用状态
      emp.seteIsenabled(1);
      // 设置时间
      emp.seteUpdatetime(timeUtil.getCurrentTimestamp());
      emp.seteCreatetime(timeUtil.getCurrentTimestamp());

      // 插入数据
      if (empMapper.createEmp(emp) != 1) {
        throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "创建用户失败");
      }

      // 赋予初始角色 3普通用户
      empRoleService.insertEmpRole(emp.getId(), 3);
      // 赋予基本权限 emp
      empMenuService.addEmpMenu(emp.getId(), Collections.singletonList(1));

      return ResultResponse.success();
    } catch (Exception e) {
      log.error("注册用户时发生错误", e);
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "创建用户失败");
    }
  }

  @Override
  public ResultResponse loginByToken() {
    // 从 SecurityContextHolder 获取当前用户信息
    UserDetails userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    log.info("账户：" + userDetails.getUsername() + "，通过token登录");
    // 如果用户存在，返回最新的用户信息
    if (userDetails != null) {
      if (empMapper.getEmp(new Emp(userDetails.getUsername())).geteIsenabled() == 0) {
        throw new BizException(ExceptionEnum.UNAUTHORIZED, "该用户已被禁用，请联系管理员");
      }
      Role role =
          roleMapper.findRoleByEmpId(empMapper.getEmp(new Emp(userDetails.getUsername())).getId());
      Dept dept =
          deptMapper.getDept(
              new Dept(empMapper.getEmp(new Emp(userDetails.getUsername())).geteDeptid()));
      // 在redis中设置该id的在线状态为1

      return ResultResponse.success(
          new EmpRoleDeptDTO(empMapper.getEmp(new Emp(userDetails.getUsername())), role, dept, 1));
    } else {
      throw new BizException(ExceptionEnum.UNAUTHORIZED, "授权失败，该用户不存在");
    }
  }

  @Override
  public ResultResponse logout() {

    return ResultResponse.success("退出登陆成功");
  }
}
