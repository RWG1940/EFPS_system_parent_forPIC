package com.rs.service;

import com.rs.domain.ImportantMsg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rs.exception.pojo.vo.ResultResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author RWG
* @description 针对表【important_msg】的数据库操作Service
* @createDate 2024-09-03 14:47:12
*/
@Service
public interface ImportantMsgService extends IService<ImportantMsg> {

    ResultResponse getImportantMsgs();

    ResultResponse getPages(Integer page, Integer pageSize);

    ResultResponse searchImportantMsgs(ImportantMsg importantMsg);

    ResultResponse addImportantMsgs(ImportantMsg importantMsg);

    ResultResponse updateImportantMsgs(ImportantMsg importantMsg);

    ResultResponse deleteBatchImportantMsgs(List<Integer> ids);
}
