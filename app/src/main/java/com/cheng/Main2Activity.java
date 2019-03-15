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
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");
        strings.add("http://dopepic.yupfashion.cn/4365/20190314021336.052/1552500816Kb7c65La6XwlN360Mcse.png");


        FriendsCircleImageLayout imageLayout = (FriendsCircleImageLayout) findViewById(R.id.circle);
        imageLayout.setImageUrls( strings,90,110);
    }
}
