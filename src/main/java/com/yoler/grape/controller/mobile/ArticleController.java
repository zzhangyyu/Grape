package com.yoler.grape.controller.mobile;

import com.yoler.grape.request.mobile.ArticleListReq;
import com.yoler.grape.request.mobile.ArticleReq;
import com.yoler.grape.service.mobile.user.ArticleService;
import com.yoler.grape.util.GsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 文章controller
 */
@RestController
@RequestMapping(value = "/article/")
@Api(tags = "Article", description = "文章相关接口")
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;

    @ApiOperation(value = "获取文章列表", notes = "获取文章列表")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getArticleList")
    public String getArticleList(@RequestBody String reqJson) {
        logger.debug("getArticleList req is :" + reqJson);
        ArticleListReq req = GsonUtil.jsonToObject(reqJson, ArticleListReq.class);
        Map<String, Object> resultMap = articleService.getArticleList(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getArticleList resp is :" + result);
        return result;
    }

    @ApiOperation(value = "获取文章内容", notes = "获取文章内容")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getArticle")
    public String getArticle(@RequestBody String reqJson) {
        logger.debug("getArticle req is :" + reqJson);
        ArticleReq req = GsonUtil.jsonToObject(reqJson, ArticleReq.class);
        Map<String, Object> resultMap = articleService.getArticle(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getArticle resp is :" + result);
        return result;
    }

}
