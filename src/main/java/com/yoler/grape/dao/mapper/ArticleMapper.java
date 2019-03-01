package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.Article;
import com.yoler.grape.vo.mobile.ArticleListVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-文章Mapper
 */
public interface ArticleMapper extends BaseMapper<Article, Integer> {
    List<ArticleListVo> getArticleList(Map<String, Object> queryMap);
}
