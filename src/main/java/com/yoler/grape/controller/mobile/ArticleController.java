package com.yoler.grape.controller.mobile;

import com.yoler.grape.request.mobile.ArticleListReq;
import com.yoler.grape.request.mobile.ArticleReq;
import com.yoler.grape.service.mobile.user.ArticleService;
import com.yoler.grape.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 文章controller
 */
@RestController
@RequestMapping(value = "/article/")
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "getArticleList", method = RequestMethod.POST)
    public String getArticleList(@RequestBody String reqJson) {
        logger.debug("getArticleList req is :" + reqJson);
        ArticleListReq req = GsonUtil.jsonToObject(reqJson, ArticleListReq.class);
        Map<String, Object> resultMap = articleService.getArticleList(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getArticleList resp is :" + result);
        return result;
    }

    @RequestMapping(value = "getArticle", method = RequestMethod.POST)
    public String getArticle(@RequestBody String reqJson) {
        logger.debug("getArticle req is :" + reqJson);
        ArticleReq req = GsonUtil.jsonToObject(reqJson, ArticleReq.class);
        Map<String, Object> resultMap = articleService.getArticle(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getArticle resp is :" + result);
        return result;
    }

}
