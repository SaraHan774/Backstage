package com.gahee.backstage.data.tags;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "rss", strict = false)
public class Rss implements Serializable {

    @Element(name = "channel")
    private Channel channel;

    public Rss(){

    }

    public Channel getChannel() {
        return channel;
    }
}
