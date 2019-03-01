package com.yoler.grape.service.mobile.user.impl;

import com.yoler.grape.dao.mapper.ArticleMapper;
import com.yoler.grape.entity.Article;
import com.yoler.grape.request.mobile.ArticleListReq;
import com.yoler.grape.request.mobile.ArticleReq;
import com.yoler.grape.service.mobile.user.ArticleService;
import com.yoler.grape.util.StringUtil;
import com.yoler.grape.vo.mobile.ArticleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Map<String, Object> getArticleList(ArticleListReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        String pageIdxStr = req.getContent().getPageIdx();
        String recordPerPageStr = req.getContent().getRecordPerPage();
        int pageIdx = StringUtil.isEmpty(pageIdxStr) ? 1 : Integer.parseInt(req.getContent().getPageIdx());
        int recordPerPage = StringUtil.isEmpty(recordPerPageStr) ? 20 : Integer.parseInt(req.getContent().getRecordPerPage());
        int beginRowNum = (pageIdx - 1) * recordPerPage;
        queryMap.put("beginRowNum", beginRowNum);
        queryMap.put("recordPerPage", recordPerPage);
        List<ArticleListVo> articleListVos = articleMapper.getArticleList(queryMap);
        result.put("content", articleListVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getArticle(ArticleReq articleReq) {
        Map<String, Object> result = new HashMap<>();
        String articleId = articleReq.getContent().getArticleId();
        if (!StringUtil.isEmpty(articleId)) {
            Article article = articleMapper.get(Integer.parseInt(articleId));
            result.put("content", article);
            result.put("status", "200");
        }
        return result;
    }
}
