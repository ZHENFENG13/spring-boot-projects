package com.site.springboot.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class News {
    private Long newsId;

    private String newsTitle;

    private Long newsCategoryId;

    private String newsCoverImage;

    private String newsContent;

    private Byte newsStatus;

    private Long newsViews;

    private Byte isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public Long getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Long newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public String getNewsCoverImage() {
        return newsCoverImage;
    }

    public void setNewsCoverImage(String newsCoverImage) {
        this.newsCoverImage = newsCoverImage == null ? null : newsCoverImage.trim();
    }

    public Byte getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Byte newsStatus) {
        this.newsStatus = newsStatus;
    }

    public Long getNewsViews() {
        return newsViews;
    }

    public void setNewsViews(Long newsViews) {
        this.newsViews = newsViews;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsCategoryId=").append(newsCategoryId);
        sb.append(", newsCoverImage=").append(newsCoverImage);
        sb.append(", newsStatus=").append(newsStatus);
        sb.append(", newsViews=").append(newsViews);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}