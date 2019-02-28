package org.nix.lovedomain.photo.controller.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.nix.lovedomain.photo.model.Photo;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 一个相册的所有照片
 * @date 2019/2/28
 */
@Data
public class AlbumPhotosDto extends BaseDto {

    public interface DetailAlbumPhotoView extends BaseResult, Photo.DetailPhotoView {
    }

    public interface SimpleAlbumPhotoView extends BaseResult, Photo.SimplePhotoView {
    }


    public AlbumPhotosDto(Integer code, String msg, List<Photo> photos) {
        super(code, msg);
        this.photos = photos;
    }

    @JsonView(value = {DetailAlbumPhotoView.class, SimpleAlbumPhotoView.class})
    private List<Photo> photos;

}
