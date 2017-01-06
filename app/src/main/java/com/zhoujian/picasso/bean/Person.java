package com.zhoujian.picasso.bean;

/**
 * Created by zhoujian on 2017/1/6.
 */

public class Person
{
    private String pictureUrl;
    private String content;
    public Person(String pictureUrl,String content)
    {

        this.pictureUrl = pictureUrl;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
