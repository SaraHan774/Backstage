package com.gahee.backstage.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.gahee.backstage.R;
import com.gahee.backstage.data.models.ChannelInfo;
import com.gahee.backstage.data.models.ItemInfo;
import com.gahee.backstage.data.remote.MyViewModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyViewModel myViewModel;
    TextView tvChannelTitle;
    TextView tvChannelSummary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main_podcast);
        tvChannelTitle = findViewById(R.id.tv_channel_title);
        tvChannelSummary = findViewById(R.id.tv_channel_summary);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        myViewModel.fetchDataFromRepo();

        myViewModel.getItemInfoFromRepo().observe(this , new Observer<ArrayList<ItemInfo>>() {
            @Override
            public void onChanged(ArrayList<ItemInfo> itemInfoArrayList) {
                MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(MainActivity.this, itemInfoArrayList);
                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
            }
        });



        myViewModel.getChannelInfoFromRepo().observe(this, new Observer<ChannelInfo>() {
            @Override
            public void onChanged(ChannelInfo channelInfo) {
                setMainText(channelInfo);
            }
        });
    }

    private void setMainText(ChannelInfo channelInfo){
        String title = channelInfo.getmChannelTitle() != null ? channelInfo.getmChannelTitle() : "";
        String summary = channelInfo.getmChannelSummary() != null ? channelInfo.getmChannelSummary() : "";
        String channelLink = channelInfo.getmChannelLink() != null ? channelInfo.getmChannelLink() : "";

        tvChannelTitle.setText(title);
        tvChannelSummary.setText(summary);

        //set on click function to navigate to channel link
    }
}
