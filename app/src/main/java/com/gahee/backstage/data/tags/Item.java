package com.gahee.backstage.data.tags;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "item", strict = false)
public class Item implements Serializable{

    @Element(name = "title")
    private String itemTitle;

    @Element(name = "link")
    private String itemLink;

    @Path("item/author")
    @Element(name = "author", required = false)
    private String itemAuthor;

    @Element(name = "pubDate", required = false)
    private String itemPubDate;

    @Element(name = "summary", required = false)
    private String itemSummary;

    @Element(name = "enclosure")
    private Enclosure enclosure;

    @Element(name = "thumbnail", required = false)
    private Thumbnail thumbnail;

    public Item(){

    }


    @Root(name = "enclosure", strict = false)
    public static class Enclosure implements Serializable{
        @Attribute(name = "url")
        private String audioUrl;

        public Enclosure(){

        }

        public String getAudioUrl() {
            return audioUrl;
        }
    }

    @Root(name = "thumbnail", strict = false)
    public static class Thumbnail implements Serializable {
        @Attribute(name = "url")
        private String thumbnailUrl;

        public Thumbnail(){

        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemLink() {
        return itemLink;
    }

    public String getItemAuthor() {
        return itemAuthor;
    }

    public String getItemPubDate() {
        return itemPubDate;
    }

    public String getItemSummary() {
        return itemSummary;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
}
