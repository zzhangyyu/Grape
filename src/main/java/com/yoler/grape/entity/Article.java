package com.yoler.grape.entity;

/**
 * 数据库表映射-文章
 */
public class Article {
    private int id;
    private String author;
    private String writingTime;
    private String title1;
    private String title2;
    private String para;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWritingTime() {
        return writingTime;
    }

    public void setWritingTime(String writingTime) {
        this.writingTime = writingTime;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
