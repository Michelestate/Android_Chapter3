package com.example.chapter3.homework;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {

    private static final String TAG = "CH3EX3";
    private static final int PAGE_COUNT =2;

    // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
    // TODO: ex3-2, 添加 TabLayout 支持 Tab
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"已进入CH3EX3\n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);
        Log.d(TAG,"已进入新页面\n");
        ViewPager view_pager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        Log.d(TAG,"1\n");
        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int i) {
                return new PlaceholderFragment();
            }

            @Override
            public int getCount() {
                return PAGE_COUNT;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0)       return "好友列表";
                else if (position == 1)  return "我的好友";
                return null;
            }
        });
        Log.d(TAG,"2\n");
        tabLayout.setupWithViewPager(view_pager);
        Log.d(TAG,"3\n");
    }
}





