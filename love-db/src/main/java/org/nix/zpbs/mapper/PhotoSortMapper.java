package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.PhotoSort;
import org.nix.zpbs.model.PhotoSortExample;

public interface PhotoSortMapper {
    int countByExample(PhotoSortExample example);

    int deleteByExample(PhotoSortExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhotoSort record);

    int insertSelective(PhotoSort record);

    List<PhotoSort> selectByExample(PhotoSortExample example);

    PhotoSort selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhotoSort record, @Param("example") PhotoSortExample example);

    int updateByExample(@Param("record") PhotoSort record, @Param("example") PhotoSortExample example);

    int updateByPrimaryKeySelective(PhotoSort record);

    int updateByPrimaryKey(PhotoSort record);
}