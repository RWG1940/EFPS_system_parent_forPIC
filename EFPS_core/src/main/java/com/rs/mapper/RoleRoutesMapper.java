package com.rs.mapper;

import com.rs.domain.RoleRoutes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【role_routes】的数据库操作Mapper
* @createDate 2024-10-09 17:42:55
* @Entity com.rs.domain.RoleRoutes
*/
@Mapper
public interface RoleRoutesMapper extends BaseMapper<RoleRoutes> {

    List<Integer> getRouteIdsByRoleId(Integer getrId);

    int insertBatch(List<RoleRoutes> roleRoutesList);
}




