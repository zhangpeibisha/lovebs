package org.nix.zpbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.nix.zpbs.model.ArticleSort;
import org.nix.zpbs.model.ArticleSortExample;

public interface ArticleSortMapper {
    int countByExample(ArticleSortExample example);

    int deleteByExample(ArticleSortExample example);

    int deleteByPrimaryKey(Integer sortArticleId);

    int insert(ArticleSort record);

    int insertSelective(ArticleSort record);

    List<ArticleSort> selectByExample(ArticleSortExample example);

    ArticleSort selectByPrimaryKey(Integer sortArticleId);

    int updateByExampleSelective(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByExample(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByPrimaryKeySelective(ArticleSort record);

    int updateByPrimaryKey(ArticleSort record);
}