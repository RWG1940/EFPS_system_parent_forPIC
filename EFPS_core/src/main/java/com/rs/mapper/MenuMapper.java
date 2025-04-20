package com.rs.mapper;

import com.rs.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【menu】的数据库操作Mapper
* @createDate 2024-08-09 21:12:13
* @Entity com.rs.domain.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectMenuById(int i);

    List<Menu> searchList(Menu menu);
}




