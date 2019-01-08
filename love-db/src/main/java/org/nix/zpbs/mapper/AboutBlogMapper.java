package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.AboutBlog;
import org.nix.zpbs.model.AboutBlogExample;

public interface AboutBlogMapper {
    int countByExample(AboutBlogExample example);

    int deleteByExample(AboutBlogExample example);

    int deleteByPrimaryKey(Integer blogId);

    int insert(AboutBlog record);

    int insertSelective(AboutBlog record);

    List<AboutBlog> selectByExample(AboutBlogExample example);

    AboutBlog selectByPrimaryKey(Integer blogId);

    int updateByExampleSelective(@Param("record") AboutBlog record, @Param("example") AboutBlogExample example);

    int updateByExample(@Param("record") AboutBlog record, @Param("example") AboutBlogExample example);

    int updateByPrimaryKeySelective(AboutBlog record);

    int updateByPrimaryKey(AboutBlog record);
}