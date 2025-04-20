package com.rs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rs.domain.EmpMenu;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.EmpMenuService;
import com.rs.mapper.EmpMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author RWG
* @description 针对表【emp_menu】的数据库操作Service实现
* @createDate 2024-10-30 20:50:30
*/
@Service
public class EmpMenuServiceImpl extends ServiceImpl<EmpMenuMapper, EmpMenu>
    implements EmpMenuService{
    @Autowired
    private EmpMenuMapper empMenuMapper;
    @Override
    public ResultResponse getAllEmpMenu(Integer eId) {
        QueryWrapper<EmpMenu> q = new QueryWrapper<>();
        q.eq("e_id",eId);
        List<EmpMenu> list = empMenuMapper.selectList(q);
        if (list.size() > 0){
            return ResultResponse.success(list);
        }
        return ResultResponse.error("该用户没有权限");
    }

    @Override
    public ResultResponse addEmpMenu(Integer eId, List<Integer> mIdList) {
        // 创建 QueryWrapper，用于检查是否有重复的路由
        QueryWrapper<EmpMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("e_id", eId).in("m_id", mIdList);

        // 查找是否有重复的路由
        List<EmpMenu> existingMenus = empMenuMapper.selectList(queryWrapper);
        if (!existingMenus.isEmpty()) {
            // 获取已存在的路由 ID 列表
            List<Integer> existingmIds =
                    existingMenus.stream().map(EmpMenu::getmId).collect(Collectors.toList());
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "角色已拥有以下路由: " + existingmIds);
        }

        // 构建需要插入的 RoleRoutes 列表
        List<EmpMenu> empMenuList = new ArrayList<>();
        for (Integer mId : mIdList) {
            EmpMenu empMenu = new EmpMenu();
            empMenu.seteId(eId);
            empMenu.setmId(mId);
            empMenuList.add(empMenu);
        }

        // 批量插入
        int insertCount = empMenuMapper.insertBatch(empMenuList);
        if (insertCount == 0) {
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "批量添加失败");
        } else {
            return ResultResponse.success();
        }
    }

    @Override
    public ResultResponse deleteEmpMenu(Integer id) {
        if (empMenuMapper.deleteById(id) == 0){
            throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR,"删除失败");
        }
        return ResultResponse.success();
    }
}




