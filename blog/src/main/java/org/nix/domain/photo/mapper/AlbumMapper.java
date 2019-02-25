package org.nix.domain.photo.mapper;

import org.nix.domain.photo.model.Album;
import org.nix.domain.photo.model.AlbumExample;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumMapper {
    int countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    int insertSelective(Album record);

    List<Album> selectByExampleWithBLOBs(AlbumExample example);

    List<Album> selectByExample(AlbumExample example);

    Album selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExampleWithBLOBs(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKeyWithBLOBs(Album record);

    int updateByPrimaryKey(Album record);
}