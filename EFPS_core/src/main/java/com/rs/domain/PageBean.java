package com.rs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @FileName: PageBean
 * @Date: 2024/8/1:15:52
 * @Description: 分页的实体类
 * @Author: RWG
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List rows;
}
