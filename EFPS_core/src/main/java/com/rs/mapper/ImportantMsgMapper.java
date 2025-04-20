package com.rs.mapper;

import com.rs.domain.ImportantMsg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author RWG
* @description 针对表【important_msg】的数据库操作Mapper
* @createDate 2024-09-03 14:47:12
* @Entity com.rs.domain.ImportantMsg
*/
@Mapper
public interface ImportantMsgMapper extends BaseMapper<ImportantMsg> {

    int deleteImportantMsgs(List<Integer> ids);

    int updateImportantMsgs(ImportantMsg importantMsg);

    int addImportantMsgs(ImportantMsg importantMsg);

    ImportantMsg searchImportantMsgs(ImportantMsg importantMsg);

    List<ImportantMsg> getAllImportantMsgs();
}




