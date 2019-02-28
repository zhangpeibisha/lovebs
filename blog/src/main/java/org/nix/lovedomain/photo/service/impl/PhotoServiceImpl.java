package org.nix.lovedomain.photo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.mapper.PhotoMapper;
import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.Photo;
import org.nix.lovedomain.photo.model.PhotoExample;
import org.nix.lovedomain.photo.service.PhotoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 照片服务实现
 * @date 2019/2/28
 */
@Slf4j
@Service
public class PhotoServiceImpl implements PhotoService {

    @Resource
    private PhotoMapper photoMapper;

    @Override
    public void addPhoto(Album album, Photo photo) {
        photo.setAlbumid(album.getId());
        photoMapper.insertSelective(photo);
    }

    public void addPhotos(Album album, List<Photo> photos) {
        Integer id = album.getId();
        photos.forEach(photo -> {
            photo.setAlbumid(id);
            photoMapper.insertSelective(photo);
        });

    }

    @Override
    public void updatePhoto(Photo photo) {
        photoMapper.updateByPrimaryKeySelective(photo);
    }

    @Override
    public List<Photo> selectAlbumInPhotos(Integer albumId) {
        PhotoExample example = new PhotoExample();
        example.createCriteria().andAlbumidEqualTo(albumId);
        return photoMapper.selectByExample(example);
    }
}
