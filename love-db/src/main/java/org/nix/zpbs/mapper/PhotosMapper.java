package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.Photos;
import org.nix.zpbs.model.PhotosExample;

public interface PhotosMapper {
    int countByExample(PhotosExample example);

    int deleteByExample(PhotosExample example);

    int deleteByPrimaryKey(Long photoId);

    int insert(Photos record);

    int insertSelective(Photos record);

    List<Photos> selectByExample(PhotosExample example);

    Photos selectByPrimaryKey(Long photoId);

    int updateByExampleSelective(@Param("record") Photos record, @Param("example") PhotosExample example);

    int updateByExample(@Param("record") Photos record, @Param("example") PhotosExample example);

    int updateByPrimaryKeySelective(Photos record);

    int updateByPrimaryKey(Photos record);
}