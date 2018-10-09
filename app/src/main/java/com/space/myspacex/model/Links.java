package com.space.myspacex.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Links {

    private String mission_patch;
    private String mission_patch_small;
    private String reddit_campaign;
    private String reddit_launch;
    private String reddit_recovery;
    private String reddit_media;
    private String presskit;
    private String article_link;
    private String wikipedia;
    private String video_link;
    private List<String> flickr_images = null;

    public String getMissionPatch() {
        return mission_patch;
    }

    public void setMissionPatch(String missionPatch) {
        this.mission_patch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return mission_patch_small;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.mission_patch_small = missionPatchSmall;
    }

    public String getRedditCampaign() {
        return reddit_campaign;
    }

    public void setRedditCampaign(String redditCampaign) {
        this.reddit_campaign = redditCampaign;
    }

    public String getRedditLaunch() {
        return reddit_launch;
    }

    public void setRedditLaunch(String redditLaunch) {
        this.reddit_launch = redditLaunch;
    }

    public String getRedditRecovery() {
        return reddit_recovery;
    }

    public void setRedditRecovery(String redditRecovery) {
        this.reddit_recovery = redditRecovery;
    }

    public String getRedditMedia() {
        return reddit_media;
    }

    public void setRedditMedia(String redditMedia) {
        this.reddit_media = redditMedia;
    }

    public String getPresskit() {
        return presskit;
    }

    public void setPresskit(String presskit) {
        this.presskit = presskit;
    }

    public String getArticleLink() {
        return article_link;
    }

    public void setArticleLink(String articleLink) {
        this.article_link = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return video_link;
    }

    public void setVideoLink(String videoLink) {
        this.video_link = videoLink;
    }

    public List<String> getFlickrImages() {
        return flickr_images;
    }

    public void setFlickrImages(List<String> flickrImages) {
        this.flickr_images = flickrImages;
    }


}
