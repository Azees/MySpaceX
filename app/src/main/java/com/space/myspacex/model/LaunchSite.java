package com.space.myspacex.model;

public class LaunchSite {

    private String site_id;
    private String site_name;
    private String site_name_long;

    public String getSiteId() {
        return site_id;
    }

    public void setSiteId(String siteId) {
        this.site_id = siteId;
    }

    public String getSiteName() {
        return site_name;
    }

    public void setSiteName(String siteName) {
        this.site_name = siteName;
    }

    public String getSiteNameLong() {
        return site_name_long;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.site_name_long = siteNameLong;
    }

}
