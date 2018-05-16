package com.example.android.tourguide.model;

/**
 * Class of the explore's model
 *
 * @package com.example.android.tourguide.model
 * (c) 2018, Igor Korovchenko.
 */
public class ExploreModel {

    /**
     * Enum with different type of exploration activity
     */
    public static enum Activity {WALK, RUN, BIKE, CAR, BUS, TRAIN};

    /**
     * Activities' array
     */
    private ExploreModel.Activity[] activities;

    /**
     * Name of the route
     */
    private String name;

    /**
     * Average duration of the route in minutes
     */
    private int duration;

    /**
     * Default constructor
     *
     * @param name of the route
     * @param duration of the route
     * @param activities of the route
     */
    public ExploreModel(String name, int duration, ExploreModel.Activity[] activities) {
        this.name = name;
        this.duration = duration;
        this.activities = activities;
    }

    /**
     * Getting the name of the route
     *
     * @return name of the route
     */
    public String getName() {
        return name;
    }

    /**
     * Getting the duration of the route
     *
     * @return duration of the route
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Getting activities of the route
     *
     * @return activities of the route
     */
    public ExploreModel.Activity[] getActivities() {
        return activities;
    }
}
