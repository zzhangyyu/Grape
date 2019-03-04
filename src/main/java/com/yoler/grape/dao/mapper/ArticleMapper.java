package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.Article;
import com.yoler.grape.vo.mobile.ArticleListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * mybatis-文章Mapper
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article, Integer> {
    List<ArticleListVo> getArticleList(Map<String, Object> queryMap);
}
