package com.zhjw.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhjw.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName MasterUserMapper
 * @Author LENOVO
 * @Date 2021/10/19 10:33
 * @Description
 * @Version 1.0
 */
@Mapper
public interface MasterUserMapper extends BaseMapper<User> {
}
