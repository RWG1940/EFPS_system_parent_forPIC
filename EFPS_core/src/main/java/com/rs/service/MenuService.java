package com.rs.service;

import com.rs.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.exception.pojo.vo.ResultResponse;

import java.util.List;

/**
* @author RWG
* @description 针对表【menu】的数据库操作Service
* @createDate 2024-08-09 21:12:13
*/
public interface MenuService extends IService<Menu> {

    List<String> selectMenuById(int i);

    ResultResponse getPages(Integer page, Integer pageSize);

    ResultResponse getPermissions(Menu menu);

    ResultResponse getAllPermissions();

    ResultResponse deletePermissions(Integer[] ids);

    ResultResponse addPermissions(Menu menu);

    ResultResponse updatePermissions(Menu menu);
}
