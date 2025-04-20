package com.rs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rs.domain.Menu;
import com.rs.domain.PageBean;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.MenuService;
import com.rs.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
* @author RWG
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2024-08-09 21:12:13
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<String> selectMenuById(int i) {
        return menuMapper.selectMenuById(i);
    }

    @Override
    public ResultResponse getPages(Integer page, Integer pageSize) {
        // 启动分页
        PageHelper.startPage(page, pageSize);
        List<Menu> menuList = menuMapper.selectList(null);
        Page<Menu> p = (Page<Menu>) menuList;
        return ResultResponse.success(new PageBean(p.getTotal(), p.getResult()));

    }

    @Override
    public ResultResponse getPermissions(Menu menu) {
        return ResultResponse.success(menuMapper.searchList(menu));
    }

    @Override
    public ResultResponse getAllPermissions() {
        return ResultResponse.success(menuMapper.selectList(null));
    }

    @Override
    public ResultResponse deletePermissions(Integer[] ids) {
        if (ids == null){
            return ResultResponse.error("参数错误");
        }
        if (menuMapper.deleteBatchIds(Arrays.asList(ids)) == 0){
            return ResultResponse.error("删除失败");
        }
        return ResultResponse.success();
    }

    @Override
    public ResultResponse addPermissions(Menu menu) {
        if (menu == null){
            return ResultResponse.error("参数错误");
        }
        if (menuMapper.insert(menu) == 0){
            return ResultResponse.error("添加失败");
        }
        return ResultResponse.success();
    }

    @Override
    public ResultResponse updatePermissions(Menu menu) {
        if (menu == null){
            return ResultResponse.error("参数错误");
        }
        if (menuMapper.updateById(menu) == 0){
            return ResultResponse.error("更新失败");
        }
        return ResultResponse.success();
    }
}




