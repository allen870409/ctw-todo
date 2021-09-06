package com.qiaoyc.ctwtodo.service.impl;

import com.qiaoyc.ctwtodo.entity.Todo;
import com.qiaoyc.ctwtodo.mapper.TodoMapper;
import com.qiaoyc.ctwtodo.service.TodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author Qiao Yicheng
 * @since 2021-09-06
 */
@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements TodoService {

}
