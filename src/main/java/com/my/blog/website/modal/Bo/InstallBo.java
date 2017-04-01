package com.my.blog.website.modal.Bo;

import com.my.blog.website.dto.DataSource;

/**
 * Created by BlueT on 2017/3/4.
 */
public class InstallBo extends DataSource {
    private String adminUser;
    private String siteTitle;
    private String siteUrl;
    private String adminEmail;
    private String adminPwd;

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    @Override
    public String toString() {
        return "InstallBo{" +
                "adminUser='" + adminUser + '\'' +
                ", siteTitle='" + siteTitle + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }
}
