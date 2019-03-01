package org.nix.lovedomain.photo.controller.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.nix.lovedomain.photo.model.Album;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 用户相册列表信息
 * @date 2019/3/1
 */
@Data
public class AlbumListDto extends BaseDto {

    public interface AlbumListView extends BaseDto.BaseResult, Album.DetailAlbumView {
    }

    public AlbumListDto(Integer code, String msg, List<Album> albums) {
        super(code, msg);
        this.albums = albums;
    }

    @JsonView(value = AlbumListView.class)
    private List<Album> albums;

}
