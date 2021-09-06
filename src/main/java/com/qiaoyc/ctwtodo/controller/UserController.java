package com.qiaoyc.ctwtodo.controller;

import com.qiaoyc.ctwtodo.dto.LoginDto;
import com.qiaoyc.ctwtodo.service.UserService;
import com.qiaoyc.ctwtodo.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Qiao Yicheng
 * @since 2021-09-06
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",required = true)
    })
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto userDto){
        Result result = userService.checkLogin(userDto.getUsername(), userDto.getPassword());
        return result;
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户注册账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户注册密码",required = true)
    })
    @PostMapping("/register")
    public Result register(@RequestBody LoginDto userDto){
        Result result= userService.userRegister(userDto.getUsername(), userDto.getPassword());
        return result;
    }

}
