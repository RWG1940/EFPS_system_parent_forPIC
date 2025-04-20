package com.rs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rs.domain.ImportantMsg;
import com.rs.domain.PageBean;
import com.rs.exception.pojo.BizException;
import com.rs.exception.pojo.ExceptionEnum;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.ImportantMsgService;
import com.rs.mapper.ImportantMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RWG
 * @description 针对表【important_msg】的数据库操作Service实现
 * @createDate 2024-09-03 14:47:12
 */
@Service
public class ImportantMsgServiceImpl extends ServiceImpl<ImportantMsgMapper, ImportantMsg>
    implements ImportantMsgService {
  @Autowired private ImportantMsgMapper importantMsgMapper;

  @Override
  public ResultResponse deleteBatchImportantMsgs(List<Integer> ids) {
    if (importantMsgMapper.deleteImportantMsgs(ids) > 0) {
      return ResultResponse.success();
    } else {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "删除失败");
    }
  }

  @Override
  public ResultResponse updateImportantMsgs(ImportantMsg importantMsg) {
    importantMsg.setUpdatetime(new java.util.Date());
    if (importantMsgMapper.updateImportantMsgs(importantMsg) > 0) {
      return ResultResponse.success();
    } else {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "修改失败");
    }
  }

  @Override
  public ResultResponse addImportantMsgs(ImportantMsg importantMsg) {
    importantMsg.setCreatetime(new java.util.Date());
    importantMsg.setUpdatetime(new java.util.Date());
    if (importantMsgMapper.addImportantMsgs(importantMsg) > 0) {
      return ResultResponse.success();
    } else {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "添加失败");
    }
  }

  @Override
  public ResultResponse searchImportantMsgs(ImportantMsg importantMsg) {
    if (importantMsgMapper.searchImportantMsgs(importantMsg) != null) {
      return ResultResponse.success(importantMsgMapper.searchImportantMsgs(importantMsg));
    } else {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "查询失败");
    }
  }

  @Override
  public ResultResponse getPages(Integer page, Integer pageSize) {
    PageHelper.startPage(page, pageSize);
    List<ImportantMsg> importantMsg = importantMsgMapper.getAllImportantMsgs();
    if (importantMsg == null) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "获取数据失败");
    }
    PageInfo<ImportantMsg> pageInfo = new PageInfo<>(importantMsg);
    return ResultResponse.success(new PageBean(pageInfo.getTotal(), pageInfo.getList()));
  }

  @Override
  public ResultResponse getImportantMsgs() {
    List<ImportantMsg> importantMsg = importantMsgMapper.getAllImportantMsgs();
    if (importantMsg == null) {
      throw new BizException(ExceptionEnum.INTERNAL_SERVER_ERROR, "获取数据失败");
    }
    return ResultResponse.success(importantMsg);
  }
}
