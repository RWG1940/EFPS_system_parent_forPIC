package com.rs.mapper;

import com.rs.domain.EmpMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【emp_menu】的数据库操作Mapper
* @createDate 2024-10-30 20:50:30
* @Entity com.rs.domain.EmpMenu
*/
@Mapper
public interface EmpMenuMapper extends BaseMapper<EmpMenu> {

    int insertBatch(List<EmpMenu> empMenuList);

    List<String> selectRoleList(Integer id);
}




