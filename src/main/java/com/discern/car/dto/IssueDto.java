package com.discern.car.dto;

import java.util.Date;

/**
 * Created by Keben on 2019-04-20.
 */
public class IssueDto {
    private Integer id;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章发布时间
     */
    private Date createTime;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 主题图片
     */
    private String topicPic;

    /**
     * 被浏览的次数
     */
    private Integer viewCount;

    /**
     * 文章内容
     */
    private String content;

    private String introduce;

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicPic() {
        return topicPic;
    }

    public void setTopicPic(String topicPic) {
        this.topicPic = topicPic;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
