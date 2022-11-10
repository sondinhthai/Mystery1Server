package com.example.mystery1server.models;

public class Documents {
    private String content;
    private String imgUrl;
    private String title;

    public Documents() {
    }

    public Documents(String content, String imgUrl, String title) {
        this.content = content;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
