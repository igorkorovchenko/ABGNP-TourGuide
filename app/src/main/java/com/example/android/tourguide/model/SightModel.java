package com.example.android.tourguide.model;

/**
 * Class of the sight's model
 *
 * @package com.example.android.tourguide.model
 * (c) 2018, Igor Korovchenko.
 */
public class SightModel {

    /**
     * Name of the sight
     */
    private String name;

    /**
     * Photo of the sight
     */
    private String imageURL;

    /**
     * Default constructor
     *
     * @param name name of the sight
     * @param imageURL photo of the sight
     */
    public SightModel(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    /**
     * Getting photo URL of the sight
     *
     * @return String link
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Getting name of the sight
     *
     * @return String name
     */
    public String getName() {
        return name;
    }
}
