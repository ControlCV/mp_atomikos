package com.zhjw.controller;

import com.zhjw.common.response.ResponseResult;
import com.zhjw.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author LENOVO
 * @Date 2021/10/19 11:11
 * @Description
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult test() {
        testService.testInsert();
        return ResponseResult.success();
    }

}
