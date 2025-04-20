package com.rs.exception.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @FileName: BizException
 * @Date: 2024/8/7:16:07
 * @Description: 自定义异常类
 * @Author: RWG
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;


    protected String errorCode;

    protected String errorMsg;

    public BizException() {
        super();
    }
    /**
     * @Description: 使用枚举定义异常信息的构造方法
     * @Param:
     * @Return:
     */
    public BizException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getResultCode());
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }
    /**
     * @Description: 使用枚举定义异常信息的构造方法，并传入异常原因
     * @Param:
     * @Return:
     */
    public BizException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultCode(), cause);
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }
    /**
     * @Description: 自定义异常信息
     * @Param:
     * @Return:
     */
    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
    /**
     * @Description: 自定义异常信息和状态码
     * @Param:
     * @Return:
     */
    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    /**
     * @Description: 自定义异常信息和状态码，并传入异常原因
     * @Param:
     * @Return:
     */
    public BizException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    /**
     * @Description: 使用枚举定义异常信息的构造方法，并传入自定义异常信息
     * @Param:
     * @Return:
     */
    public BizException(BaseErrorInfoInterface errorInfoInterface, String additionalMsg) {
        super(errorInfoInterface.getResultCode());
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMsg() + ": " + additionalMsg;
    }

    /**
     * @Description: 屏蔽堆栈信息
     * @Param:
     * @Return:
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}



