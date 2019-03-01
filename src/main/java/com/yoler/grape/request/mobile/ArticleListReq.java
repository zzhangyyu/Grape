package com.yoler.grape.request.mobile;

public class ArticleListReq extends BaseReq {
    private ArticleListReqContent content;

    public ArticleListReqContent getContent() {
        return content;
    }

    public void setContent(ArticleListReqContent content) {
        this.content = content;
    }
}
