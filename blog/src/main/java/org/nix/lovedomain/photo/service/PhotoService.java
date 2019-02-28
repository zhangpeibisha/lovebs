package org.nix.lovedomain.photo.service;

import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.Photo;

/**
 * @author zhangpei
 * @version 1.0
 * @description 照片服务
 * @date 2019/2/28
 */
public interface PhotoService {

    void addPhoto(Album album, Photo photo);

    void updatePhoto(Photo photo);

}
