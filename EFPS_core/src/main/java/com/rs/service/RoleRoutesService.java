package com.rs.service;

import com.rs.domain.RoleRoutes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.exception.pojo.vo.ResultResponse;

import java.util.List;

/**
* @author RWG
* @description 针对表【role_routes】的数据库操作Service
* @createDate 2024-10-09 17:42:55
*/
public interface RoleRoutesService extends IService<RoleRoutes> {


    ResultResponse getAllRoleRoutes(Integer rId);

    ResultResponse addRoleRoutes(Integer rId, List<Integer> roIds);

    ResultResponse deleteRoleRoutes(Integer id);

}
