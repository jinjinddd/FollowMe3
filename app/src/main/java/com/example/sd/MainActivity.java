package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    HomeFragment homeFragment;
    CourseFragment courseFragment;
    ScheduleFragment scheduleFragment;
    StatisticsFragment statisticsFragment;
    MemoFragment memoFragment;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);
        homeFragment = new HomeFragment();
        courseFragment = new CourseFragment();
        scheduleFragment = new ScheduleFragment();
        statisticsFragment = new StatisticsFragment();
        memoFragment = new MemoFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment).commit();
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setIcon(R.drawable.home));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.list));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.sch));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.cal));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.postit));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = homeFragment;
                else if(position == 1)
                    selected = courseFragment;
                else if(position == 2)
                    selected = scheduleFragment;
                else if(position == 3)
                    selected = statisticsFragment;
                else if(position == 4)
                    selected = memoFragment;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}