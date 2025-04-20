package com.rs.mapper;

import com.rs.domain.DynamicRoutes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【dynamic_routes】的数据库操作Mapper
* @createDate 2024-10-09 16:07:46
* @Entity com.rs.domain.DynamicRoutes
*/
@Mapper
public interface DynamicRoutesMapper extends BaseMapper<DynamicRoutes> {

    List<DynamicRoutes> getRoutesByIds(List<Integer> routeIds);

    List<DynamicRoutes> getAllRoutes();

    List<DynamicRoutes> getRoutes(DynamicRoutes route);

    int insertRoute(DynamicRoutes route);

    int updateRoute(DynamicRoutes route);
}




