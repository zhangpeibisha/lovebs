package org.nix.zpbs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.pojo.dto.response.user.UserResponseDetailDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;


/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@Slf4j
@Api(description = "博客应用的测试API")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @ApiOperation(nickname = "欢迎来到博客测试接口 hello", value = "hello word ,一个测试接口", notes = "返回数据为 用户名 hello + 时间")
    @ApiImplicitParam(name = "username", paramType = "path", dataType = "String", required = true, value = "用户名字")
    @GetMapping(value = "/hello/{username:[a-zA-Z]{8,16}$}")
    public String hello(@PathVariable(value = "username") String userName) {
        return userName + " hello world ";
    }

    @PreAuthorize(value = "hasAuthority('测试资源')")
    @ApiOperation(nickname = "一个需要登陆权限的接口", value = "拥有权限", notes = "如果拥有这个接口的权限则返回：用户名+你是一个有权限的用户")
    @ApiImplicitParam(name = "username", paramType = "path", dataType = "String", required = true, value = "用户名字")
    @GetMapping(value = "/power/{username}")
    public String havePower(@PathVariable(value = "username") String userName) {
        return userName + "你是一个有权限的用户";
    }

    @PreAuthorize(value = "hasAuthority('没有权限')")
    @ApiOperation(nickname = "一个不可能有权限的接口", value = "不拥有权限", notes = "这个接口不可能被访问到")
    @ApiImplicitParam(name = "username", paramType = "path", dataType = "String", required = true, value = "用户名字")
    @GetMapping(value = "/haveNot/power/{username}")
    public String haveNotPower(@PathVariable(value = "username") String userName) {
        return userName + "你是一个有权限的用户";
    }

    @ApiOperation(nickname = "findUserSimpleInfo", value = "测试控制返回数据的接口", notes = "测试JsonView标签的使用方法")
    @ApiImplicitParam(name = "id", paramType = "path", dataType = "String", required = true, value = "用户id")
    @JsonView(UserResponseDetailDTO.UserSimpleDTO.class)
    @GetMapping(value = "/simple/user/{id:[0-9]+}")
    public UserResponseDetailDTO findUserSimpleInfo(@PathVariable(value = "id") Long id) {
        UserResponseDetailDTO userResponseDetailDTO = new UserResponseDetailDTO();
        userResponseDetailDTO.setUserName("张沛");
        userResponseDetailDTO.setId(id);
        userResponseDetailDTO.setUserPhone(18203085236L);
        userResponseDetailDTO.setUserEmail("zhangpe03122@qq.com");
        userResponseDetailDTO.setUserAddress("重庆市江津区");
        return userResponseDetailDTO;
    }


    // 异步调用勾子，用来线程间传递信息
    private DeferredResult<String> deferredResult = new DeferredResult<>();

    /**
     * @author zhangpe0312@qq.com
     * @description spring mvc 异步处理测试
     * @date 20:49 2019/1/15
     * @return 处理结果
     */
    @ApiOperation(nickname = "queryOrder", value = "测试异步获取返回结果接口", notes = "测试异步获取返回结果接口")
    @GetMapping(value = "/order")
    public DeferredResult<String> queryOrder() {
        log.info("进入查询订单接口等待信息");
        return deferredResult;
    }

    @ApiOperation(nickname = "dealWithOrder", value = "测试异步设置返回结果接口", notes = "测试异步设置返回结果接口")
    @ApiImplicitParam(name = "orderName", paramType = "path", dataType = "String", required = true, value = "订单名字")
    @GetMapping(value = "/order/{orderName}")
    public String dealWithOrder(@PathVariable String orderName){
        deferredResult.setResult(orderName);
        log.info("订单结果已经处理完");
        return "success " + orderName;
    }

}
