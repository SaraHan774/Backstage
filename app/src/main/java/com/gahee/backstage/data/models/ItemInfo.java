package com.gahee.backstage.data.models;

import com.gahee.backstage.data.tags.Item;

public class ItemInfo {
    private String mItemTitle;
    private String mItemLink;
    private String mItemAuthor;
    private String mItemPubDate;
    private String mItemSummary;
    private Item.Enclosure mEnclosure;
    private Item.Thumbnail mThumbnail;

    public ItemInfo(String mItemTitle, String mItemLink, String mItemAuthor, String mItemPubDate, String mItemSummary, Item.Enclosure mEnclosure, Item.Thumbnail mThumbnail) {
        this.mItemTitle = mItemTitle;
        this.mItemLink = mItemLink;
        this.mItemAuthor = mItemAuthor;
        this.mItemPubDate = mItemPubDate;
        this.mItemSummary = mItemSummary;
        this.mEnclosure = mEnclosure;
        this.mThumbnail = mThumbnail;
    }

    public String getmItemTitle() {
        return mItemTitle;
    }

    public String getmItemLink() {
        return mItemLink;
    }

    public String getmItemAuthor() {
        return mItemAuthor;
    }

    public String getmItemPubDate() {
        return mItemPubDate;
    }

    public String getmItemSummary() {
        return mItemSummary;
    }

    public Item.Enclosure getmEnclosure() {
        return mEnclosure;
    }

    public Item.Thumbnail getmThumbnail() {
        return mThumbnail;
    }
}
