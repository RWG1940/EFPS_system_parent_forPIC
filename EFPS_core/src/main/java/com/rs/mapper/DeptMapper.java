package com.rs.mapper;

import com.rs.domain.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rs.domain.DeptCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【dept】的数据库操作Mapper
* @createDate 2024-07-28 12:03:30
* @Entity com.rs.domain.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    List<Dept> getAllDepts();

    List<Dept> getDepts(Dept dept);

    Dept getDept(Dept dept);

    int createDept(Dept dept);

    int updateDept(Dept dept);

    int deleteDept(Integer id);

    int deleteDepts(List<Integer> ids);

    List<DeptCount> findDeptIdCount();
}




