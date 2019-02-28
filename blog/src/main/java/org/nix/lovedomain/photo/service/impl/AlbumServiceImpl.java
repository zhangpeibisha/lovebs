package org.nix.lovedomain.photo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.mapper.AlbumMapper;
import org.nix.lovedomain.photo.mapper.UserMapper;
import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.AlbumExample;
import org.nix.lovedomain.photo.model.User;
import org.nix.lovedomain.photo.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 相册实现
 * @date 2019/2/28
 */
@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {

    @Resource
    private AlbumMapper albumMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public void addAlbum(User user, Album album) {
        album.setOwnerid(user.getId());
        albumMapper.insertSelective(album);
    }

    @Override
    public void updateAlbum(Album album) {
        albumMapper.updateByPrimaryKeySelective(album);
    }

    @Override
    public List<Album> selectAlbumListByUser(User user) {
        AlbumExample example = new AlbumExample();
        example.createCriteria().andOwneridEqualTo(user.getId());
        return albumMapper.selectByExample(example);
    }
}
