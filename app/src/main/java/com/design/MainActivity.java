package com.design;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.design.adapter.TabAdapter;
import com.design.fragments.TabFragment;
import com.design.listeners.AppBarStateChangeListener;

public class MainActivity extends AppCompatActivity {

    private AppBarLayout appBar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBar = (AppBarLayout) findViewById(R.id.appBar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("");
        appBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {

            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if(state == State.EXPANDED ) {
                    //展开状态
                    collapsingToolbarLayout.setTitle("");
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    collapsingToolbarLayout.setTitle("lalo");
                }else {
                    //中间状态
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        TabFragment[] fragments = new TabFragment[2];
        for(int i=0;i<2;i++){
            Bundle data = new Bundle();
            data.putString("fragment_param","Fragment"+i);
            fragments[i] = TabFragment.newInstance(data);

        }

        tabAdapter = new TabAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(tabAdapter);
    }

}
