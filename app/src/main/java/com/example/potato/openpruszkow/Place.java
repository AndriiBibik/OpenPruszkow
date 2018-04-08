package com.example.potato.openpruszkow;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Potato on 03.10.2017.
 */

public class Place {

    //image resource id
    private int mainImageId;

    //place title
    private String title;

    //short description about place
    private String shortDescription;

    //coordinate to sent maps intent later
    private double[] coordinates;

    //Uri for place location
    private String placeUri;

    //more pictures files names
    private int[] placePicturesIds;

    //opening hours for places like restaurants etc.
    private OpeningHours openingHours;


    //this counstructor is used for places like parks, places for exersizes, where you cannot aply opening hours
    public Place(int mainImageId, String title, String shortDescription, double[] coordinates, int[] placePicturesIds) {
        this.mainImageId = mainImageId;
        this.title = title;
        this.shortDescription = shortDescription;
        this.coordinates = coordinates;
        this.placeUri = "http://www.google.com/maps/search/?api=1&query=" + coordinates[0] + "," + coordinates[1];
        this.placePicturesIds = placePicturesIds;
    }


    //this constructor is used for places like restaurants, where we want to specify opening hours
    public Place(int mainImageId, String title, String shortDescription, double[] coordinates, OpeningHours openingHours) {
        this.mainImageId = mainImageId;
        this.title = title;
        this.shortDescription = shortDescription;
        this.coordinates = coordinates;
        this.placeUri = "http://www.google.com/maps/search/?api=1&query=" + coordinates[0] + "," + coordinates[1];
        this.openingHours = openingHours;
    }

    // returning of Main image for this Place
    public int getMainImageId() {
        return mainImageId;
    }

    // returning title for this place
    public String getTitle() {
        return title;
    }

    // returning description for this place
    public String getShortDescription() {
        return shortDescription;
    }

    // checks if there is array for pictures ids initialized
    public boolean isPlacePicturesIdsSet() {
        if (placePicturesIds == null)
            return false;
        return true;
    }

    // returns array with additional pictures, always should be used with isPlacePicturesIdsSet method
    public int[] getPlacePicturesIds() {
        return placePicturesIds;
    }

    // checks if there is opening hours initialized
    public boolean isOpeningHoursSet() {
        if (openingHours == null)
            return false;
        return true;
    }

    // returnts formatted openingHours. This method should be used with isOpeningHoursSet method
    public String[] getFormattedOpeningHours() {
        return openingHours.formatedOpeningHours();
    }

    // Returns String with url to specific place for list item
    public String getMapsUri() {
        return placeUri;
    }
}
