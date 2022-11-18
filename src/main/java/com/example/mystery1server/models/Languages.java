package com.example.mystery1server.models;

public class Languages {
    private String textLanguage;
    private String tag;

    public Languages() {
    }

    public Languages(String textLanguage) {
        this.textLanguage = textLanguage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTextLanguage() {
        return textLanguage;
    }

    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
    }
}
