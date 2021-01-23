package com.moten.DemoA.type;

public class news {
    // 新闻类
    public int news_icon;
    public String news_title;
    public String news_content;
    public String news_number;
    public String news_date;

    public int getNews_icon() {
        return news_icon;
    }

    public void setNews_icon(int news_icon) {
        this.news_icon = news_icon;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_number() {
        return news_number;
    }

    public void setNews_number(String news_number) {
        this.news_number = news_number;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public news(
            int news_icon,
            String news_title,
            String news_content,
            String news_number,
            String news_date){
        this.news_icon=news_icon;
        this.news_title=news_title;
        this.news_content=news_content;
        this.news_number=news_number;
        this.news_date=news_date;
    }
}
