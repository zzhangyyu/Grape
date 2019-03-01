package com.yoler.grape.service.mobile.user;

import com.yoler.grape.request.mobile.ArticleListReq;
import com.yoler.grape.request.mobile.ArticleReq;

import java.util.Map;

public interface ArticleService {
    Map<String, Object> getArticleList(ArticleListReq articleListReq);

    Map<String, Object> getArticle(ArticleReq articleReq);
}
