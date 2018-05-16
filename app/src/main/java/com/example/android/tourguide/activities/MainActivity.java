package com.example.android.tourguide.activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.controller.CategoryPagerAdapter;

public class MainActivity extends AppCompatActivity {

    /**
     * Adapter for all pages as category of content
     */
    private CategoryPagerAdapter mCategoryPagerAdapter;

    /**
     * The ViewPager that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCategoryPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager(), this);
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mCategoryPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new PageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.add_note_message), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        updateState(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void updateState(int i) {
        String category = mCategoryPagerAdapter.getCategory(i);
        FloatingActionButton fab = findViewById(R.id.fab);
        if (!category.equals(CategoryPagerAdapter.NOTES_CATEGORY_NAME)) {
            fab.setVisibility(View.GONE);
        } else {
            fab.setVisibility(View.VISIBLE);
        }
    }

    private class PageChangeListener extends TabLayout.TabLayoutOnPageChangeListener {

        PageChangeListener(TabLayout tabLayout) {
            super(tabLayout);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            updateState(mViewPager.getCurrentItem());
        }
    }
}
