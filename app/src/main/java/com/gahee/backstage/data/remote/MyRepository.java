package com.gahee.backstage.data.remote;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.gahee.backstage.data.models.ChannelInfo;
import com.gahee.backstage.data.models.ItemInfo;

import java.util.ArrayList;

public class MyRepository {


    RetrofitClient retrofitClient;

    private static MyRepository instance;

    public static MyRepository getInstance() {
        if(instance == null){
            instance = new MyRepository();
        }
        return instance;
    }


    private MyRepository(){

        retrofitClient = retrofitClient.getInstance();

    }

    private static class FetchDataAsync extends AsyncTask<Void, Void, Void> {

        private RetrofitClient retrofitClient;
        public FetchDataAsync(RetrofitClient retrofitClient) {
            this.retrofitClient = retrofitClient;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            retrofitClient.fetchDataFromBackStage();
            return null;
        }

    }

    public void fetchDataFromClient(){
        new FetchDataAsync(retrofitClient).execute();
    }

    public MutableLiveData<ChannelInfo> getChannelInfoFromClient(){
        return retrofitClient.getChannelInfoMutableLiveData();
    }

    public MutableLiveData<ArrayList<ItemInfo>> getItemInfoFromClient(){
        return retrofitClient.getItemInfoMutableLiveData();
    }


}
