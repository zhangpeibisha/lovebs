package org.nix.lovedomain.photo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.oss.OssProperties;
import org.nix.lovedomain.oss.SpringMvcOssServiceImpl;
import org.nix.lovedomain.photo.controller.dto.AlbumPhotosDto;
import org.nix.lovedomain.photo.controller.dto.BaseDto;
import org.nix.lovedomain.photo.mapper.AlbumMapper;
import org.nix.lovedomain.photo.model.Album;
import org.nix.lovedomain.photo.model.Photo;
import org.nix.lovedomain.photo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
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

    @Autowired
    private OssProperties ossProperties;

    @Resource
    private AlbumMapper albumMapper;

    @ApiOperation(value = "查看相册的所有照片,详细信息")
    @GetMapping(value = "/detail/{album}")
    @JsonView(value = AlbumPhotosDto.DetailAlbumPhotoView.class)
    public AlbumPhotosDto getDetailAlbumPhotos(@PathVariable(value = "album") Integer albumId) {
        return getAlbumPhotos(albumId);
    }

    @ApiOperation(value = "查看相册的所有照片,简约信息信息")
    @GetMapping(value = "/simple/{album}")
    @JsonView(value = AlbumPhotosDto.SimpleAlbumPhotoView.class)
    public AlbumPhotosDto getSimpleAlbumPhotos(@PathVariable(value = "album") Integer albumId) {
        return getAlbumPhotos(albumId);
    }

    private AlbumPhotosDto getAlbumPhotos(Integer albumId) {
        List<Photo> photos = photoService.selectAlbumInPhotos(albumId);
        return new AlbumPhotosDto(200, "获取相册照片信息成功", photos);
    }

    @ApiOperation(value = "批量添加照片进入指定相册中")
    @PostMapping(value = "/{album}", headers = "multipart/form-data")
    public WebAsyncTask addPhotos(MultipartFile[] files, @PathVariable(value = "album") Integer album) throws IOException {
        SpringMvcOssServiceImpl springMvcOssService = new SpringMvcOssServiceImpl(ossProperties);
        Album exitAlbum = albumMapper.selectByPrimaryKey(album);
        if (exitAlbum == null) {
            throw new ControllerException("相册不存在");
        }
        // 1 分钟超时
        long timeOut = 1000 * 60;
        WebAsyncTask<BaseDto> webAsyncTask = new WebAsyncTask<>(timeOut, () -> {
            for (MultipartFile file : files) {
                try {
                    String uploadUrl = springMvcOssService.upload(file);
                    Photo photo = new Photo();
                    photo.setUrl(uploadUrl);
                    photo.setName(file.getOriginalFilename());
                    photo.setAlbumid(album);
                    photoService.addPhoto(exitAlbum, photo);
                } catch (IOException e) {
                    throw new IOException("上传文件失败", e);
                }
            }
            return new BaseDto(200, "上传图片成功");
        });
        webAsyncTask.onCompletion(() -> log.info("上传照片成功"));
        webAsyncTask.onTimeout(() -> new BaseDto(500, "处理请求超时，请减少上传数据的数量"));
        return webAsyncTask;
    }

    @ApiOperation(value = "单个照片进入指定相册中")
    @PostMapping(value = "/{album}")
    public BaseDto addPhotos(MultipartFile file, @PathVariable(value = "album") Integer album) throws IOException {
        SpringMvcOssServiceImpl springMvcOssService = new SpringMvcOssServiceImpl(ossProperties);
        Album exitAlbum = albumMapper.selectByPrimaryKey(album);
        if (exitAlbum == null) {
            throw new ControllerException("相册不存在");
        }
        String uploadUrl = springMvcOssService.upload(file);
        Photo photo = new Photo();
        photo.setUrl(uploadUrl);
        photo.setName(file.getOriginalFilename());
        photo.setAlbumid(album);
        photoService.addPhoto(exitAlbum, photo);
        return new BaseDto(200,"上传图片成功");
    }
}
