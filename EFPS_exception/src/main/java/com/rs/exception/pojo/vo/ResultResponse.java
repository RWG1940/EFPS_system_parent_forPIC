package com.rs.exception.pojo.vo;

import com.alibaba.fastjson.JSONObject;
import com.rs.exception.pojo.BaseErrorInfoInterface;
import com.rs.exception.pojo.ExceptionEnum;
import lombok.Data;

/**
 * @FileName: ResultResponse
 * @Date: 2024/8/7:16:09
 * @Description: 数据传输
 * @Author: RWG
 */
@Data
public class ResultResponse<T> {

        private String code;


        private String message;


        private T result;

        public ResultResponse() {
        }

        public ResultResponse(BaseErrorInfoInterface errorInfo) {
            this.code = errorInfo.getResultCode();
            this.message = errorInfo.getResultMsg();
        }

        public static ResultResponse success() {
            return success(null);
        }


        public static ResultResponse success(Object data) {
            ResultResponse rb = new ResultResponse();
            rb.setCode(ExceptionEnum.SUCCESS.getResultCode());
            rb.setMessage(ExceptionEnum.SUCCESS.getResultMsg());
            rb.setResult(data);
            return rb;
        }


        public static ResultResponse error(BaseErrorInfoInterface errorInfo) {
            ResultResponse rb = new ResultResponse();
            rb.setCode(errorInfo.getResultCode());
            rb.setMessage(errorInfo.getResultMsg());
            rb.setResult(null);
            return rb;
        }


        public static ResultResponse error(String code, String message) {
            ResultResponse rb = new ResultResponse();
            rb.setCode(code);
            rb.setMessage(message);
            rb.setResult(null);
            return rb;
        }


        public static ResultResponse error( String message) {
            ResultResponse rb = new ResultResponse();
            rb.setCode("-1");
            rb.setMessage(message);
            rb.setResult(null);
            return rb;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

    }