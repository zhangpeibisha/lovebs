package org.nix.lovedomain.photo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.controller.dto.AlbumListDto;
import org.nix.lovedomain.photo.mapper.UserMapper;
import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.User;
import org.nix.lovedomain.photo.service.impl.AlbumServiceImpl;
import org.nix.lovedomain.photo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 相册控制器
 * @date 2019/3/1
 */
@Slf4j
@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AlbumServiceImpl albumService;

    @JsonView(value = AlbumListDto.AlbumListView.class)
    @GetMapping(value = "/albumList/{user}")
    public AlbumListDto getAlbumListByUser(@PathVariable(value = "user") Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        List<Album> albums = albumService.selectAlbumListByUser(user);
        log.info("查询到的相册信息为:{}", albums);
        return new AlbumListDto(200, "获取用户" + user.getUsername() + "的相册信息成功", albums);
    }

}
