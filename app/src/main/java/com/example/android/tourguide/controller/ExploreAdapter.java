package com.example.android.tourguide.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.model.ExploreModel;

import java.util.ArrayList;

/**
 * Class of ExploreAdapter
 *
 * @package com.example.android.tourguide.controller
 * (c) 2018, Igor Korovchenko.
 */
public class ExploreAdapter extends ArrayAdapter<ExploreModel> {

    /**
     * Current context of the app
     */
    private Context mContext;

    /**
     * List of values
     */
    private ArrayList<ExploreModel> mValues;

    ExploreAdapter(@NonNull Context context, @NonNull ArrayList<ExploreModel> objects) {
        super(context, R.layout.explore_item, objects);
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
        View rowView = inflater.inflate(R.layout.explore_item, parent, false);
        TextView durationTime = rowView.findViewById(R.id.explore_duration_time);
        durationTime.setText(String.valueOf(mValues.get(position).getDuration()));
        TextView routeName = rowView.findViewById(R.id.explore_route_name);
        routeName.setText(mValues.get(position).getName());
        ExploreModel.Activity activities[] = mValues.get(position).getActivities();
        for (ExploreModel.Activity activity : activities) {
            if (activity == ExploreModel.Activity.BIKE) {
                ImageView icon = rowView.findViewById(R.id.explore_transport_type_bike);
                icon.setVisibility(View.VISIBLE);
            } else if (activity == ExploreModel.Activity.BUS) {
                ImageView icon = rowView.findViewById(R.id.explore_transport_type_bus);
                icon.setVisibility(View.VISIBLE);
            } else if (activity == ExploreModel.Activity.CAR) {
                ImageView icon = rowView.findViewById(R.id.explore_transport_type_car);
                icon.setVisibility(View.VISIBLE);
            } else if (activity == ExploreModel.Activity.RUN) {
                ImageView icon = rowView.findViewById(R.id.explore_transport_type_run);
                icon.setVisibility(View.VISIBLE);
            } else if (activity == ExploreModel.Activity.WALK) {
                ImageView icon = rowView.findViewById(R.id.explore_transport_type_walk);
                icon.setVisibility(View.VISIBLE);
            } else if (activity == ExploreModel.Activity.TRAIN) {
                ImageView icon = rowView.findViewById(R.id.explore_transport_type_train);
                icon.setVisibility(View.VISIBLE);
            }
        }
        return rowView;
    }

    public static class Builder {

        /**
         * Setup the adapter
         *
         * @param context current context of the app
         * @return ExploreModel
         */
        public static ExploreAdapter getExploreAdapter(@NonNull Context context) {
            ArrayList<ExploreModel> list = new ArrayList<>(0);
            ExploreModel.Activity[] activities = {ExploreModel.Activity.BUS, ExploreModel.Activity.WALK};
            list.add(new ExploreModel("Museums of Voronezh", 240, activities));
            activities = new ExploreModel.Activity[2];
            activities[0] = ExploreModel.Activity.CAR;
            activities[1] = ExploreModel.Activity.WALK;
            list.add(new ExploreModel("Kostenki", 180, activities));
            activities = new ExploreModel.Activity[2];
            activities[0] = ExploreModel.Activity.TRAIN;
            activities[1] = ExploreModel.Activity.WALK;
            list.add(new ExploreModel("Divnogorie", 360, activities));
            activities = new ExploreModel.Activity[1];
            activities[0] = ExploreModel.Activity.WALK;
            list.add(new ExploreModel("City center", 240, activities));
            activities = new ExploreModel.Activity[1];
            activities[0] = ExploreModel.Activity.RUN;
            list.add(new ExploreModel("Morning sea", 40, activities));
            return new ExploreAdapter(context, list);
        }
    }
}
