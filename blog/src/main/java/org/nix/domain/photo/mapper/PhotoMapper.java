package org.nix.domain.photo.mapper;

import org.nix.domain.photo.model.Photo;
import org.nix.domain.photo.model.PhotoExample;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoMapper {
    int countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}