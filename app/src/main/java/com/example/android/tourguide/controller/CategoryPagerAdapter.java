package com.example.android.tourguide.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.android.tourguide.model.CategoryFragment;

/**
 * Class of CategoryPagerAdapter
 *
 * @package com.example.android.tourguide
 * (c) 2018, Igor Korovchenko.
 */
public class CategoryPagerAdapter extends FragmentPagerAdapter {

    /**
     * Names of categories
     */
    public static final String EXPLORE_CATEGORY_NAME = "Explore";
    public static final String SIGHTS_CATEGORY_NAME = "Sights";
    public static final String FOOD_CATEGORY_NAME = "Food";
    public static final String NOTES_CATEGORY_NAME = "Notes";

    /**
     * Current category
     */
    private String mCategory = "";

    /**
     * Current context of the app
     */
    private Context mContext;

    public CategoryPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                mCategory = EXPLORE_CATEGORY_NAME;
                break;
            case 1:
                mCategory = SIGHTS_CATEGORY_NAME;
                break;
            case 2:
                mCategory = FOOD_CATEGORY_NAME;
                break;
            case 3:
                mCategory = NOTES_CATEGORY_NAME;
                break;
        }
        CategoryFragment fragment = CategoryFragment.newInstance(mCategory);
        if (mContext != null) {
            fragment.setContext(mContext);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    public String getCategory(int index) {
        switch (index) {
            case 0:
                return EXPLORE_CATEGORY_NAME;
            case 1:
                return SIGHTS_CATEGORY_NAME;
            case 2:
                return FOOD_CATEGORY_NAME;
            case 3:
                return NOTES_CATEGORY_NAME;
        }
        return "";
    }
}
