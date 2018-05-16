package com.example.android.tourguide.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.model.FoodPlaceModel;

import java.util.ArrayList;

/**
 * Class of FoodPlaceAdapter
 *
 * @package com.example.android.tourguide.controller
 * (c) 2018, Igor Korovchenko.
 */
public class FoodPlaceAdapter extends ArrayAdapter<FoodPlaceModel> {

    /**
     * Dimension
     */
    private final String DISTANCE_DIMENSION = "km";

    /**
     * Current context of the app
     */
    private Context mContext;

    /**
     * List of values
     */
    private ArrayList<FoodPlaceModel> mValues;

    FoodPlaceAdapter(@NonNull Context context, @NonNull ArrayList<FoodPlaceModel> objects) {
        super(context, R.layout.food_item, objects);
        mContext = context;
        mValues = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (mContext == null) {
            return null;
        }
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("ViewHolder")
        View rowView = inflater.inflate(R.layout.food_item, parent, false);
        TextView placeName = rowView.findViewById(R.id.food_place_name);
        placeName.setText(mValues.get(position).getName());
        TextView placeDistance = rowView.findViewById(R.id.food_distance);
        placeDistance.setText(String.valueOf(mValues.get(position).getDistance()) + " " + DISTANCE_DIMENSION);
        ImageView placeTypeItem = rowView.findViewById(R.id.food_place_type);
        placeTypeItem.setImageDrawable(mContext.getResources().getDrawable(mValues.get(position).getType()));
        RatingBar placeRating = rowView.findViewById(R.id.food_rating_bar);
        LayerDrawable stars = (LayerDrawable) placeRating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(mContext.getResources().getColor(R.color.primaryColor), PorterDuff.Mode.SRC_ATOP);
        placeRating.setRating(mValues.get(position).getRating());
        return rowView;
    }

    public static class Builder {

        /**
         * Setup the adapter
         *
         * @param context current context of the app
         * @return FoodPlaceModel
         */
        public static FoodPlaceAdapter getFoodPlaceAdapter(@NonNull Context context) {
            ArrayList<FoodPlaceModel> list = new ArrayList<>(0);
            list.add(new FoodPlaceModel(FoodPlaceModel.TYPE_LOCAL_PIZZERIA, "Noname pizza", 4.5, 4.8f));
            list.add(new FoodPlaceModel(FoodPlaceModel.TYPE_LOCAL_CAFE, "Book Club", 0.1, 5.0f));
            list.add(new FoodPlaceModel(FoodPlaceModel.TYPE_LOCAL_RESTAURANT, "Desperado", 1.5, 3.8f));
            list.add(new FoodPlaceModel(FoodPlaceModel.TYPE_LOCAL_BAR, "Bar Lusconi", 3.5, 4.2f));
            return new FoodPlaceAdapter(context, list);
        }
    }
}
