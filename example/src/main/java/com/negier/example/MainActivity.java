package com.negier.example;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.negier.gluetablayout.GlueTabLayout;

public class MainActivity extends AppCompatActivity {

    private GlueTabLayout mGlueTabLayout;
    private ViewPager mViewPager;
    private String[] weibo = {"精选", "推荐", "榜单", "故事", "综艺", "剧集", "VLOG", "明星", "电影"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return TempFragment.newInstance(weibo[i]);
            }

            @Override
            public int getCount() {
                return weibo.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return weibo[position];
            }
        });

        mGlueTabLayout = (GlueTabLayout) findViewById(R.id.glue_tab_layout);
        mGlueTabLayout.setTabMode(GlueTabLayout.MODE_SCROLLABLE);
        //GlueTabLayout 设置下划线指示器高度和颜色
        mGlueTabLayout.setSelectedTabIndicatorHeight(dp2px(4));
        mGlueTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF6F00"));
        //GlueTabLayout 设置下划线指示器圆角
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dp2px(2));
        mGlueTabLayout.setSelectedTabIndicator(gradientDrawable);
        //GlueTabLayout 设置点击圆形动画
        mGlueTabLayout.setUnboundedRipple(true);
        //GlueTabLayout 减少下划线指示器的宽度（减掉自身宽度的一半）
        mGlueTabLayout.reduceTabIndicatorWidth(0.5f);

        mGlueTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_slide_glue:
                mGlueTabLayout.setSlidingIndicatorAnimType(GlueTabLayout.AnimType.GLUE);
                break;
            case R.id.menu_slide_half_glue:
                mGlueTabLayout.setSlidingIndicatorAnimType(GlueTabLayout.AnimType.HALF_GLUE);
                break;
            case R.id.menu_slide_none:
                mGlueTabLayout.setSlidingIndicatorAnimType(GlueTabLayout.AnimType.NONE);
                break;
            case R.id.menu_click_glue:
                mGlueTabLayout.setClickIndicatorAnimType(GlueTabLayout.AnimType.GLUE);
                break;
            case R.id.menu_click_half_glue:
                mGlueTabLayout.setClickIndicatorAnimType(GlueTabLayout.AnimType.HALF_GLUE);
                break;
            case R.id.menu_click_none:
                mGlueTabLayout.setClickIndicatorAnimType(GlueTabLayout.AnimType.NONE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private int dp2px(float dp) {
        float density = this.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

}
