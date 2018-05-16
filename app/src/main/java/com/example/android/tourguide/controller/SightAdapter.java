package com.example.android.tourguide.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.model.SightModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Class of SightAdapter
 *
 * @package com.example.android.tourguide.controller
 * (c) 2018, Igor Korovchenko.
 */
public class SightAdapter extends ArrayAdapter<SightModel> {

    /**
     * Size of the channel's icon
     */
    private static final Integer ICON_WIDTH_HEIGHT = 96;

    /**
     * Current context of the app
     */
    private Context mContext;

    /**
     * List of values
     */
    private ArrayList<SightModel> mValues;

    SightAdapter(@NonNull Context context, @NonNull ArrayList<SightModel> objects) {
        super(context, R.layout.sight_item, objects);
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
        View rowView = inflater.inflate(R.layout.sight_item, parent, false);
        TextView sightName = rowView.findViewById(R.id.sight_name);
        sightName.setText(mValues.get(position).getName());
        ImageView sightImage = rowView.findViewById(R.id.sight_photo);String iconUrl = mValues.get(position).getImageURL();
        Resources r = mContext.getResources();
        float sizeInPixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ICON_WIDTH_HEIGHT, r.getDisplayMetrics());
        if (!iconUrl.equals("")) {
            Picasso.get()
                    .load(iconUrl)
                    .placeholder(R.drawable.ic_account_balance_black_48dp)
                    .error(R.drawable.ic_account_balance_black_48dp)
                    .resize((int) sizeInPixels, (int) sizeInPixels)
                    .into(sightImage);
        } else {
            Picasso.get()
                    .load(R.drawable.ic_account_balance_black_48dp)
                    .into(sightImage);
        }
        rowView.setTag(mValues.get(position));
        return rowView;
    }

    public static class Builder {

        /**
         * Setup the adapter
         *
         * @param context Current context of the app
         * @return SightAdapter
         */
        public static SightAdapter getSightAdapter(@NonNull Context context) {
            ArrayList<SightModel> list = new ArrayList<>(0);
            list.add(new SightModel("Pamyatnik \"Rotonda\"", "http://photos.wikimapia.org/p/00/04/48/36/65_big.jpg"));
            list.add(new SightModel("Monument of Glory", "http://photos.wikimapia.org/p/00/03/21/76/89_big.jpg"));
            list.add(new SightModel("Pamyatnik Gorodu Voinskoy Slavy", "http://ordenrf.ru/upload/novosty-info/voronezj-4.jpg"));
            return new SightAdapter(context, list);
        }
    }
}
