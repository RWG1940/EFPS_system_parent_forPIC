package com.rs.exception.pojo;

/**
 * @FileName: ExceptionEnum
 * @Date: 2024/8/7:16:05
 * @Description: 枚举类
 * @Author: RWG
 */
public enum ExceptionEnum implements BaseErrorInfoInterface {

    // 成功
    SUCCESS("1", "成功!"),

    // 客户端错误
    BAD_REQUEST("4000", "请求的数据格式不符!"),
    UNAUTHORIZED("4001", "未经授权!"),
    FORBIDDEN("4003", "禁止访问!"),
    NOT_FOUND("4004", "未找到该资源!"),
    METHOD_NOT_ALLOWED("4005", "不允许的方法!"),
    REQUEST_TIMEOUT("4008", "请求超时!"),
    CONFLICT("4009", "资源冲突!"),
    UNSUPPORTED_MEDIA_TYPE("4015", "不支持的媒体类型!"),

    // 服务端错误
    INTERNAL_SERVER_ERROR("5000", "服务器内部错误!"),
    NOT_IMPLEMENTED("5001", "尚未实施!"),
    BAD_GATEWAY("5002", "错误的网关!"),
    SERVICE_UNAVAILABLE("5003", "服务不可用!"),
    GATEWAY_TIMEOUT("5004", "网关超时!"),
    HTTP_VERSION_NOT_SUPPORTED("5005", "HTTP版本不支持!"),

    // 自定义业务错误
    BODY_NOT_MATCH("4000","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("4001","请求的数字签名不匹配!"),
    SERVER_BUSY("5003","服务器正忙，请稍后再试!"),
    DATABASE_ERROR("6000", "数据库操作失败!"),
    VALIDATION_ERROR("6001", "数据验证失败!"),
    AUTHENTICATION_ERROR("6002", "认证失败!"),
    AUTHORIZATION_ERROR("6003", "授权失败!");


    private final String resultCode;
    private final String resultMsg;

    ExceptionEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
