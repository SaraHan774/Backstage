package com.gahee.backstage.data.models;

import com.gahee.backstage.data.tags.Item;

import java.util.List;

public class ChannelInfo{

    private String mChannelTitle;
    private String mChannelLink;
    private String mChannelSummary;
    private List<Item> mItems;

    public ChannelInfo(String mChannelTitle, String mChannelLink, String mChannelSummary, List<Item> mItems) {
        this.mChannelTitle = mChannelTitle;
        this.mChannelLink = mChannelLink;
        this.mChannelSummary = mChannelSummary;
        this.mItems = mItems;
    }

    public String getmChannelTitle() {
        return mChannelTitle;
    }

    public String getmChannelLink() {
        return mChannelLink;
    }

    public String getmChannelSummary() {
        return mChannelSummary;
    }

    public List<Item> getmItems() {
        return mItems;
    }
}
