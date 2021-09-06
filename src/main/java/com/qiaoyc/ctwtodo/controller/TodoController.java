package com.qiaoyc.ctwtodo.controller;


import com.qiaoyc.ctwtodo.entity.Todo;
import com.qiaoyc.ctwtodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 任务 前端控制器
 * </p>
 *
 * @author Qiao Yicheng
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    TodoService todoService;

    @RequestMapping("/{id}")
    @ResponseBody
    public Todo list(@PathVariable Integer id) {
        return todoService.getById(id);
    }
}
