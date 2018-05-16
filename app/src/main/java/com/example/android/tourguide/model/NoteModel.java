package com.example.android.tourguide.model;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class of the note's model
 *
 * @package com.example.android.tourguide.model
 * (c) 2018, Igor Korovchenko.
 */
public class NoteModel {

    private final String DATE_TIME_FORMAT = "MM/dd/yy";

    /**
     * Name of the note
     */
    private String name;

    /**
     * Summary of the note
     */
    private String summary;

    /**
     * Creation date of the note
     */
    private Calendar date;

    /**
     * Default constructor
     *
     * @param name of the note
     * @param summary of the note
     * @param date of the note
     */
    public NoteModel(String name, String summary, Calendar date) {
        this.name = name;
        this.summary = summary;
        this.date = date;
    }

    /**
     * Getting the name of the note
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getting the summary of the note
     *
     * @return String summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Getting creation date of the note
     *
     * @return String date
     */
    public String getDate() {
        @SuppressLint("SimpleDateFormat")
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        return df.format(date.getInstance().getTime());
    }
}
