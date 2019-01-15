package org.nix.zpbs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.nix.zpbs.pojo.dto.response.UserResponseDetailDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/6
 */
@Api(description = "博客应用的测试API")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @ApiOperation(nickname = "欢迎来到博客测试接口 hello",value = "hello word ,一个测试接口",notes = "返回数据为 用户名 hello + 时间")
    @ApiImplicitParam(name = "username",paramType = "path",dataType = "String",required = true,value = "用户名字")
    @GetMapping(value = "/hello/{username:[a-zA-Z]{8,16}$}")
    public String hello(@PathVariable(value = "username")String userName){
        return userName + " hello world ";
    }

    @PreAuthorize(value = "hasAuthority('测试资源')")
    @ApiOperation(nickname = "一个需要登陆权限的接口",value = "拥有权限",notes = "如果拥有这个接口的权限则返回：用户名+你是一个有权限的用户")
    @ApiImplicitParam(name = "username",paramType = "path",dataType = "String",required = true,value = "用户名字")
    @GetMapping(value = "/power/{username}")
    public String havePower(@PathVariable(value = "username")String userName){
        return userName+"你是一个有权限的用户";
    }

    @PreAuthorize(value = "hasAuthority('没有权限')")
    @ApiOperation(nickname = "一个不可能有权限的接口",value = "不拥有权限",notes = "这个接口不可能被访问到")
    @ApiImplicitParam(name = "username",paramType = "path",dataType = "String",required = true,value = "用户名字")
    @GetMapping(value = "/haveNot/power/{username}")
    public String haveNotPower(@PathVariable(value = "username")String userName){
        return userName+"你是一个有权限的用户";
    }

    @ApiOperation(nickname = "findUserSimpleInfo",value = "测试控制返回数据的接口",notes = "测试JsonView标签的使用方法")
    @ApiImplicitParam(name = "id",paramType = "path",dataType = "String",required = true,value = "用户id")
    @JsonView(UserResponseDetailDTO.UserSimpleDTO.class)
    @GetMapping(value = "/simple/user/{id:[0-9]+}")
    public UserResponseDetailDTO findUserSimpleInfo(@PathVariable(value = "id")Long id){
        UserResponseDetailDTO userResponseDetailDTO = new UserResponseDetailDTO();
        userResponseDetailDTO.setUserName("张沛");
        userResponseDetailDTO.setId(id);
        userResponseDetailDTO.setUserPhone(18203085236L);
        userResponseDetailDTO.setUserEmail("zhangpe03122@qq.com");
        userResponseDetailDTO.setUserAddress("重庆市江津区");
        return userResponseDetailDTO;
    }

}
