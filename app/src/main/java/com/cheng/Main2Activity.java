package com.cheng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cheng.channelview.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("123456");
        strings.add("3333");
        strings.add("3333");
        strings.add("3333");
        strings.add("3333");
        strings.add("3333");
        strings.add("3333");
        strings.add("3333");

        FriendsCircleImageLayout imageLayout = (FriendsCircleImageLayout) findViewById(R.id.circle);
        imageLayout.setImageUrls( strings);
    }
}
