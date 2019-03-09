package org.nix.lovedomain.photo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.controller.dto.AlbumListDto;
import org.nix.lovedomain.photo.controller.dto.BaseDto;
import org.nix.lovedomain.photo.mapper.UserMapper;
import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.User;
import org.nix.lovedomain.photo.service.impl.AlbumServiceImpl;
import org.nix.lovedomain.photo.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 相册控制器
 * @date 2019/3/1
 */
@Slf4j
@Api(value = "相册相关接口")
@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AlbumServiceImpl albumService;

    @ApiOperation(value = "获取指定用户的相册列表")
    @JsonView(value = AlbumListDto.AlbumListView.class)
    @GetMapping(value = "/albumList/{user}")
    public AlbumListDto getAlbumListByUser(@PathVariable(value = "user") Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        List<Album> albums = albumService.selectAlbumListByUser(user);
        log.info("查询到的相册信息为:{}", albums);
        return new AlbumListDto(200, "获取用户" + user.getUsername() + "的相册信息成功", albums);
    }

    @ApiOperation(value = "用户创建相册")
    @JsonView(value = BaseDto.BaseResult.class)
    @PostMapping
    public BaseDto addAlbum(Authentication authentication, Album album) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User user = userService.selectUserByAccount(username);
            albumService.addAlbum(user, album);
            return new BaseDto(200, "创建相册" + album.getName() + "成功");
        }
        return new BaseDto(400,"用户未登陆认证");
    }

}
