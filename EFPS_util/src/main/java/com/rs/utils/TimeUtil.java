package com.rs.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @FileName: TimeUtil
 * @Date: 2024/8/4:11:40
 * @Description: 时间操作工具
 * @Author: RWG
 */
@Component
public class TimeUtil {

    public Timestamp getCurrentTimestamp() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        Calendar calendar = Calendar.getInstance(timeZone);
        Date now = calendar.getTime();
        return new Timestamp(now.getTime());
    }
}
