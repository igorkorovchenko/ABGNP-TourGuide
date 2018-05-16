package com.example.android.tourguide.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.model.NoteModel;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class NoteAdapter
 *
 * @package com.example.android.tourguide.controller
 * (c) 2018, Igor Korovchenko.
 */
public class NoteAdapter extends ArrayAdapter<NoteModel> {

    /**
     * Current context of the app
     */
    private Context mContext;

    /**
     * List of values
     */
    private ArrayList<NoteModel> mValues;

    /**
     * Default constructor
     *
     * @param context current app's context
     * @param objects array of NoteModel elements
     */
    NoteAdapter(@NonNull Context context, @NonNull ArrayList<NoteModel> objects) {
        super(context, R.layout.note_item, objects);
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
        View rowView = inflater.inflate(R.layout.note_item, parent, false);
        TextView noteTitle = rowView.findViewById(R.id.note_title);
        noteTitle.setText(mValues.get(position).getName());
        TextView noteSummary = rowView.findViewById(R.id.note_summary);
        noteSummary.setText(mValues.get(position).getSummary());
        TextView noteDate = rowView.findViewById(R.id.note_date);
        noteDate.setText(mValues.get(position).getDate());
        return rowView;
    }

    public static class Builder {

        /**
         * Setup the adapter
         *
         * @param context current context of the app
         * @return NoteAdapter
         */
        public static NoteAdapter getNoteAdapter(@NonNull Context context) {
            ArrayList<NoteModel> list = new ArrayList<>(0);
            list.add(new NoteModel("Adventures in downtown", "It was very interesting voyage...", Calendar.getInstance()));
            list.add(new NoteModel("Conversation..", "Maybe people are crazy, maybe are not, but I...", Calendar.getInstance()));
            return new NoteAdapter(context, list);
        }
    }
}
