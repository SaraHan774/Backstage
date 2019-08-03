package com.gahee.backstage.data.tags;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "channel", strict =  false)
public class Channel implements Serializable {

    @Element(name = "title")
    private String title;

    @Path("channel/link")
    @Element(name = "link")
    private String link;

    @Element(name = "summary")
    private String summary;

    @ElementList(entry = "item", inline = true)
    private List<Item> items;

    public Channel(){

    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getSummary() {
        return summary;
    }

    public List<Item> getItems() {
        return items;
    }


}
