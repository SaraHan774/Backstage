package com.gahee.backstage.data;

import com.gahee.backstage.data.tags.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    String BASE_URL = "http://feeds.feedburner.com/blogspot/";

    @GET("AndroidDevelopersBackstage")
    Call<Rss> getBackstagePodcast();
}
