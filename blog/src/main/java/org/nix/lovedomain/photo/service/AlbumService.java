package org.nix.lovedomain.photo.service;

import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.User;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 相册服务
 * @date 2019/2/28
 */
public interface AlbumService {

    void addAlbum(User user, Album album);

    void updateAlbum(Album album);

    List<Album> selectAlbumListByUser(User user);

}
