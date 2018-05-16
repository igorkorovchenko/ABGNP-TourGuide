package com.example.android.tourguide.model;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.controller.ExploreAdapter;
import com.example.android.tourguide.controller.FoodPlaceAdapter;
import com.example.android.tourguide.controller.NoteAdapter;
import com.example.android.tourguide.controller.SightAdapter;

/**
 * Class
 *
 * @package com.example.android.tourguide
 * (c) 2018, Igor Korovchenko.
 */
public class CategoryFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String CATEGORY_NAME = "category";

    /**
     * Current context of the app
     */
    private Context mContext;

    /**
     * Default constructor
     */
    public CategoryFragment() {
    }

    /**
     * Setting of the app context
     *
     * @param context Context
     */
    public void setContext(Context context) {
        if (mContext == null) mContext = context;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CategoryFragment newInstance(String categoryName) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_NAME, categoryName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        assert getArguments() != null;
        String category = getArguments().getString(CATEGORY_NAME);
        assert category != null;
        if (mContext == null) {
            return null;
        }
        View rootView;
        ArrayAdapter adapter;
        ListView list;
        switch (category) {
            case "Explore":
                rootView = inflater.inflate(R.layout.fragment_list, container, false);
                adapter = ExploreAdapter.Builder.getExploreAdapter(mContext);
                list = rootView.findViewById(R.id.list);
                list.setAdapter(adapter);
                return rootView;
            case "Sights":
                rootView = inflater.inflate(R.layout.fragment_grid, container, false);
                adapter = SightAdapter.Builder.getSightAdapter(mContext);
                GridView grid = rootView.findViewById(R.id.grid);
                grid.setAdapter(adapter);
                return rootView;
            case "Food":
                rootView = inflater.inflate(R.layout.fragment_list, container, false);
                adapter = FoodPlaceAdapter.Builder.getFoodPlaceAdapter(mContext);
                list = rootView.findViewById(R.id.list);
                list.setAdapter(adapter);
                return rootView;
            case "Notes":
                rootView = inflater.inflate(R.layout.fragment_list, container, false);
                adapter = NoteAdapter.Builder.getNoteAdapter(mContext);
                list = rootView.findViewById(R.id.list);
                list.setAdapter(adapter);
                return rootView;
        }
        return null;
    }
}
