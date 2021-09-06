package com.qiaoyc.ctwtodo.dto;/**
 * Author：qiao_yicheng
 * Date：2021/09/07 0:00
 */

/**
 * Author：qiao_yicheng
 * Date：2021/09/07 0:00
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    private String username;

    private String password;
}
