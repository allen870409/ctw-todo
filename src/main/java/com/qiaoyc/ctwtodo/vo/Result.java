package com.qiaoyc.ctwtodo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Result对象",description = "封装接口返回给前端的数据")
public class Result {

    //响应给前端的状态码
    @ApiModelProperty(value = "响应状态码",dataType = "int")
    private int code;

    //响应给前端的提示信息
    @ApiModelProperty("响应提示信息")
    private String msg;

    //响应给前端的数据
    @ApiModelProperty("响应数据")
    private Object data;

    public static Result SUCCESS(Object data) {
        return SUCCESS(200, "操作成功", data);
    }


    public static Result SUCCESS(String msg, Object data) {
        Result r = new Result();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result SUCCESS(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result FAIL(String msg) {
        return FAIL(400, msg, null);
    }

    public static Result FAIL(String msg, Object data) {
        return FAIL(400, msg, data);
    }

    public static Result FAIL(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
