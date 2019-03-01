package com.yoler.grape.request.mobile;

public class ArticleReq extends BaseReq {
    private ArticleReqContent content;

    public ArticleReqContent getContent() {
        return content;
    }

    public void setContent(ArticleReqContent content) {
        this.content = content;
    }
}
