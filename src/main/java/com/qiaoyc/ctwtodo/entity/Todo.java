package com.qiaoyc.ctwtodo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务
 * </p>
 *
 * @author Qiao Yicheng
 * @since 2021-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "todo_id", type = IdType.AUTO)
    private Long todoId;

    /**
     * 任务所属人
     */
    private Long todoUserId;

    /**
     * 任务标题
     */
    private String todoTitle;

    /**
     * 任务详情
     */
    private String todoDetail;

    /**
     * 任务状态
     */
    private Integer todoStatus;

    /**
     * 任务完成期限
     */
    private LocalDateTime todoDeadline;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updatedTime;


}
