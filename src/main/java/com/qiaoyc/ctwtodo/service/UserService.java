package com.qiaoyc.ctwtodo.service;

import com.qiaoyc.ctwtodo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiaoyc.ctwtodo.vo.Result;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Qiao Yicheng
 * @since 2021-09-06
 */
public interface UserService extends IService<User> {
    //用户注册
    public Result userRegister(String name, String pwd);

    //用户登录
    public Result checkLogin(String name, String pwd);
}
