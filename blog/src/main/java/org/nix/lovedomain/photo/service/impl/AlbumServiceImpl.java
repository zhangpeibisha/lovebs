package org.nix.lovedomain.photo.service.impl;

import cn.hutool.json.JSONUtil;
import com.aliyun.oss.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.mapper.AlbumMapper;
import org.nix.lovedomain.photo.mapper.PhotoMapper;
import org.nix.lovedomain.photo.model.*;
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
    private PhotoMapper photoMapper;

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

    public Album selectAlbumByName(String albumName) {
        AlbumExample example = new AlbumExample();
        List<Album> albums = albumMapper.selectByExample(example);
        if (albums.size() == 1) {
            return albums.get(0);
        }
        log.info("{}相册名查到的相册为{}", albumName, JSONUtil.toJsonStr(albums));
        throw new ServiceException(albumName + "相册不存在");
    }

}
