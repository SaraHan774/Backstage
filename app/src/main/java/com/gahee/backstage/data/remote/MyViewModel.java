package com.gahee.backstage.data.remote;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gahee.backstage.data.models.ChannelInfo;
import com.gahee.backstage.data.models.ItemInfo;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {

    private final MyRepository myRepository;

    public MyViewModel(){
        myRepository = MyRepository.getInstance();
    }


    public void fetchDataFromRepo(){
        myRepository.fetchDataFromClient();
    }
    public MutableLiveData<ChannelInfo> getChannelInfoFromRepo(){return myRepository.getChannelInfoFromClient();}
    public MutableLiveData<ArrayList<ItemInfo>> getItemInfoFromRepo(){return myRepository.getItemInfoFromClient();}

}
