package com.cheng.channelview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cheng.Main2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void intoChannelView(View view) {
//        startActivity(new Intent(this, ChannelViewActivity.class));
        startActivity(new Intent(this, Main2Activity.class));
    }
}
