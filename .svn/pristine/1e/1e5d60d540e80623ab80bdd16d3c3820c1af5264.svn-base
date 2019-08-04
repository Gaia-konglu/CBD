package com.project.util;

/**
 * Author: 周鑫
 * Date: 2018-10-15 16:47
 * Description: <服务器响应结果对象>
 */
public class ResponseResult {
    //状态码
    private Integer status;
    //消息
    private String message;
    //数据
    private Object data;

    //成功的方法
    public static ResponseResult success(Object data){
        return new ResponseResult(LoginRegisterConstant.RESPONSE_STATUS_SUCCESS,"成功",data);
    }
    public static ResponseResult success(String message){
        return new ResponseResult(LoginRegisterConstant.RESPONSE_STATUS_SUCCESS,message,null);
    }
    //失败的方法
    public static ResponseResult fail(Object data){
        return new ResponseResult(LoginRegisterConstant.RESPONSE_STATUS_FAIL,"失败",data);
    }
    public static ResponseResult fail(String message){
        return new ResponseResult(LoginRegisterConstant.RESPONSE_STATUS_FAIL,message,null);
    }


    public ResponseResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
