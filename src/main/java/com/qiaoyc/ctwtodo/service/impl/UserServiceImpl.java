package com.qiaoyc.ctwtodo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiaoyc.ctwtodo.entity.User;
import com.qiaoyc.ctwtodo.mapper.UserMapper;
import com.qiaoyc.ctwtodo.service.UserService;
import com.qiaoyc.ctwtodo.utils.MD5Utils;
import com.qiaoyc.ctwtodo.vo.Result;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Qiao Yicheng
 * @since 2021-09-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    @Transactional
    public Result userRegister(String name, String pwd) {
        synchronized (this) {
            //1.根据用户查询，这个用户是否已经被注册
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", name);
            User requestUser = userMapper.selectOne(queryWrapper);

            //2.如果没有被注册则进行保存操作
            if (Objects.isNull(requestUser)) {
                String md5Pwd = MD5Utils.md5(pwd);
                User user = new User();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserBirthday(LocalDate.of(1987,5,9));
                int i = userMapper.insert(user);
                if (i > 0) {
                    return Result.SUCCESS("注册成功！", user);
                } else {
                    return Result.FAIL("注册失败！", null);
                }
            } else {
                return Result.FAIL("用户名已经被注册！", null);
            }
        }
    }

    @Override
    public Result checkLogin(String name, String pwd) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", name);
        User loginUser = userMapper.selectOne(queryWrapper);

        if(Objects.isNull(loginUser)){
            return Result.FAIL("登录失败，用户名不存在！",null);
        }else{
            String md5Pwd = MD5Utils.md5(pwd);
            if(md5Pwd.equals(loginUser.getPassword())){
                //如果登录验证成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
                //使用jwt规则生成token字符串
                JwtBuilder builder = Jwts.builder();

                HashMap<String,Object> map = new HashMap<>();
                map.put("userName",loginUser.getUsername());

                String token = builder.setSubject(name)                     //主题，就是token中携带的数据
                        .setIssuedAt(new Date())                            //设置token的生成时间
                        .setId(loginUser.getUserId() + "")               //设置用户id为token  id
                        .setClaims(map)                                     //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000)) //设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "Qiaoyc")     //设置加密方式和加密密码
                        .compact();

                return Result.SUCCESS(token,loginUser);
            }else{
                return Result.FAIL("登录失败，密码错误！",null);
            }
        }
    }
}
