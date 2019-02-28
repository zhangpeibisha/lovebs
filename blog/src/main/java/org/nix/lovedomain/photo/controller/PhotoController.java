package org.nix.lovedomain.photo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.photo.controller.dto.AlbumPhotosDto;
import org.nix.lovedomain.photo.model.Photo;
import org.nix.lovedomain.photo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 照片控制器
 * @date 2019/2/28
 */
@RestController
@RequestMapping(value = "/photo")
@Slf4j
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping(value = "/detail/{album}")
    @JsonView(value = AlbumPhotosDto.DetailAlbumPhotoView.class)
    public AlbumPhotosDto getDetailAlbumPhotos(@PathVariable(value = "album") Integer albumId) {
        return getAlbumPhotos(albumId);
    }

    @GetMapping(value = "/simple/{album}")
    @JsonView(value = AlbumPhotosDto.SimpleAlbumPhotoView.class)
    public AlbumPhotosDto getSimpleAlbumPhotos(@PathVariable(value = "album") Integer albumId){
       return getAlbumPhotos(albumId);
    }

    private AlbumPhotosDto getAlbumPhotos(Integer albumId){
        List<Photo> photos = photoService.selectAlbumInPhotos(albumId);
        return new AlbumPhotosDto(200, "获取相册照片信息成功", photos);
    }
}
