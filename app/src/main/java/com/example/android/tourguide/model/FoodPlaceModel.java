package com.example.android.tourguide.model;

import com.example.android.tourguide.R;

/**
 * Class of the food place's model
 *
 * @package com.example.android.tourguide.model
 * (c) 2018, Igor Korovchenko.
 */
public class FoodPlaceModel {

    /**
     * Types of food places
     */
    public static final int TYPE_LOCAL_PIZZERIA = R.drawable.ic_local_pizza_black_48dp;
    public static final int TYPE_LOCAL_CAFE = R.drawable.ic_local_cafe_black_48dp;
    public static final int TYPE_LOCAL_BAR = R.drawable.ic_local_bar_black_48dp;
    public static final int TYPE_LOCAL_RESTAURANT = R.drawable.ic_local_dining_black_48dp;

    /**
     * Type of the food place
     */
    private int type;

    /**
     * Name of the food place
     */
    private String name;

    /**
     * Distance to the food place
     */
    private double distance;

    /**
     * Rating of the food place
     */
    private float rating;

    /**
     * Default constructor
     *
     * @param type of the food place
     * @param name of the food place
     * @param distance to the food place
     * @param rating of the food place
     */
    public FoodPlaceModel(int type, String name, double distance, float rating) {
        this.type = type;
        this.name = name;
        this.distance = distance;
        this.rating = rating;
    }

    /**
     * Getting the type of the food place
     *
     * @return type of the food place
     */
    public int getType() {
        return type;
    }

    /**
     * Getting the type of the food place
     *
     * @return name of the food place
     */
    public String getName() {
        return name;
    }

    /**
     * Getting the distance to the food place
     *
     * @return distance to the food place
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Getting the rating of the food place
     *
     * @return rating of the food place
     */
    public float getRating() {
        return rating;
    }
}
