package org.nix.zpbs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@Api(description = "博客应用的测试API")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @ApiOperation(nickname = "欢迎来到博客测试接口 hello",value = "hello word ,一个测试接口",notes = "返回数据为 hello + 时间")
    @ApiImplicitParam(name = "username",paramType = "path",dataType = "String",required = true,value = "用户名字")
    @GetMapping(value = "/hello/{username}")
    public String hello(@PathVariable(value = "username")String userName){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
        return userName + " hello world " + format.format(new Date());
    }
}
