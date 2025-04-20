package com.rs.service;

import com.rs.domain.DynamicRoutes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.exception.pojo.vo.ResultResponse;
import org.springframework.stereotype.Service;

/**
* @author RWG
* @description 针对表【dynamic_routes】的数据库操作Service
* @createDate 2024-10-09 16:07:46
*/
@Service
public interface DynamicRoutesService extends IService<DynamicRoutes> {
    ResultResponse getPages(Integer page, Integer pageSize);

    ResultResponse getRoutes(DynamicRoutes route);

    ResultResponse getAllRoutes();

    ResultResponse deleteRoutes(Integer[] ids);

    ResultResponse addRoutes(DynamicRoutes route);

    ResultResponse updateRoutes(DynamicRoutes route);
}
