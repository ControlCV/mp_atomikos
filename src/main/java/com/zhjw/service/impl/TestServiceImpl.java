package com.zhjw.service.impl;

import com.zhjw.common.id.IdGenerator;
import com.zhjw.entity.User;
import com.zhjw.mapper.master.MasterUserMapper;
import com.zhjw.mapper.slave.SlaveUserMapper;
import com.zhjw.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName TestServiceImpl
 * @Author LENOVO
 * @Date 2021/10/19 11:01
 * @Description
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private MasterUserMapper masterUserMapper;

    @Resource
    private SlaveUserMapper slaveUserMapper;

    @Autowired
    private IdGenerator idGenerator;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testInsert() {
        User user1 = new User();
        user1.setId(idGenerator.generate());
        user1.setNikename("maser");
        masterUserMapper.insert(user1);
        int i =1/0;
        User user2 = new User();
        user2.setNikename("slave");
        user2.setId(idGenerator.generate());
        slaveUserMapper.insert(user2);

    }
}
