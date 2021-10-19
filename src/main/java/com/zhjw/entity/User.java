package com.zhjw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author LENOVO
 * @Date 2021/10/19 10:24
 * @Description
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3890220207610203478L;

    private Long id;

    private String mobile;

    private String password;

    private String nikename;

}
