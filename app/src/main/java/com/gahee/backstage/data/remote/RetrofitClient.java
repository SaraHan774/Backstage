package com.gahee.backstage.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.gahee.backstage.data.API;
import com.gahee.backstage.data.models.ChannelInfo;
import com.gahee.backstage.data.models.ItemInfo;
import com.gahee.backstage.data.tags.Channel;
import com.gahee.backstage.data.tags.Item;
import com.gahee.backstage.data.tags.Rss;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitClient {

    private static final String TAG = "RetrofitClient";

    private static RetrofitClient instance;

    public static RetrofitClient getInstance() {
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    private MutableLiveData<ArrayList<ItemInfo>> itemInfoMutableLiveData;
    private MutableLiveData<ChannelInfo> channelInfoMutableLiveData;

    public RetrofitClient(){
        itemInfoMutableLiveData = new MutableLiveData<>();
        channelInfoMutableLiveData = new MutableLiveData<>();
    }

    private ArrayList<ItemInfo> itemInfoArrayList = new ArrayList<>();

    private void mFetchDataFromBackStage(){
        API api = RetrofitInstanceBuilder.getApi();
        Call<Rss> call = api.getBackstagePodcast();

        call.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(@NonNull Call<Rss> call, @NonNull Response<Rss> response) {

                storeDataFromResponse(response);

            }

            @Override
            public void onFailure(@NonNull Call<Rss> call, @NonNull Throwable t) {

                Log.d(TAG, "failed to fetch data :  " + t.getMessage());

            }
        });
    }

    public void fetchDataFromBackStage(){
        mFetchDataFromBackStage();
    }

    private void storeDataFromResponse(Response<Rss> response){
        if(response.body() != null && response.body().getChannel() != null){
            Channel channel = response.body().getChannel();
            List<Item> itemList = channel.getItems();
            channelInfoMutableLiveData.setValue(new ChannelInfo(
                    channel.getTitle(),
                    channel.getLink(),
                    channel.getSummary(),
                    itemList
            ));

            for(int i = 0; i < itemList.size(); i++){
                Item item = itemList.get(i);
                itemInfoArrayList.add(new ItemInfo(
                        item.getItemTitle(),
                        item.getItemLink(),
                        item.getItemAuthor(),
                        item.getItemPubDate(),
                        item.getItemSummary(),
                        item.getEnclosure(),
                        item.getThumbnail()
                ));
            }

            itemInfoMutableLiveData.setValue(itemInfoArrayList);

        }
    }

    public MutableLiveData<ArrayList<ItemInfo>> getItemInfoMutableLiveData() {
        return itemInfoMutableLiveData;
    }

    public MutableLiveData<ChannelInfo> getChannelInfoMutableLiveData() {
        return channelInfoMutableLiveData;
    }
}
