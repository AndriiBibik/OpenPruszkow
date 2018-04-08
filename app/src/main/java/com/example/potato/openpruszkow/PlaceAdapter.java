package com.example.potato.openpruszkow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Potato on 08.10.2017.
 * ALL RIGHT RESERVED. FUNNY, HUH? HELLO FROM POLAND, PRUSZKÓW ;)
 * TERNOPIL IS A BEAUTIFUL CITY IN UKRAINE
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    // list of places
    private ArrayList<Place> listOfPlaces;

    //context
    private Context context;

    public PlaceAdapter(Context context, ArrayList<Place> listOfPlaces) {
        super(context, R.layout.place_list_item, listOfPlaces);
        this.listOfPlaces = listOfPlaces;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_list_item, parent, false);
        }

        // Getting current place for current list item
        final Place currentPlace = listOfPlaces.get(position);

        // --------Main Image-----------------------------------------------------------------------
        // Find ImageView responsible for main image
        ImageView mainImage = (ImageView) listItemView.findViewById(R.id.place_main_image);

        //Set corresponding place main image for list item
        mainImage.setImageResource(currentPlace.getMainImageId());

        //--------Listener for more images Activity-------------------------------------------------
        // Check if there is more images available for place and enable listener if needed
        if (currentPlace.isPlacePicturesIdsSet()) {
            listItemView.findViewById(R.id.place_main_image_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent morePicturesIntent = new Intent(context, MorePicturesActivity.class);

                    morePicturesIntent.putExtra("picturesArray", currentPlace.getPlacePicturesIds());
                    getContext().startActivity(morePicturesIntent);
                }
            });
        } else {
            listItemView.findViewById(R.id.more_pics_text).setVisibility(View.GONE);
        }

        //---------Place Title----------------------------------------------------------------------
        // Find TextView for place title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.place_title);

        // Set corresponding text title
        titleTextView.setText(currentPlace.getTitle());

        //---------Place Description----------------------------------------------------------------
        // Find TextView for place description
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text);

        // Set description text
        descriptionTextView.setText(currentPlace.getShortDescription());

        //---------Opening Hours--------------------------------------------------------------------
        // Find specific TextView by id
        // Days titles
        TextView openingHoursTitles = (TextView) listItemView.findViewById(R.id.opening_hours_days_titles);
        // Opening hours
        TextView openingHoursTextView = (TextView) listItemView.findViewById(R.id.opening_hours);

        // Check if there is any opening hours for current place

        if (currentPlace.isOpeningHoursSet()) {
            // Setting days titles if there any hour for this place
            openingHoursTitles.setText(currentPlace.getFormattedOpeningHours()[0]);
            // Setting opening hours if there is any for specific place
            openingHoursTextView.setText(currentPlace.getFormattedOpeningHours()[1]);
        } else
            openingHoursTextView.setVisibility(View.GONE);


        //--------Maps intent after clicking on list item-------------------------------------------
        // Setting listener for LinearLayout with Title, Description, maybe opening hours, maps icon id=place_main_information
        listItemView.findViewById(R.id.place_main_information).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // new intent for place on map
                Intent placeOnMap = new Intent(Intent.ACTION_VIEW);
                placeOnMap.setData(Uri.parse(currentPlace.getMapsUri()));

                getContext().startActivity(placeOnMap);
            }
        });

        return listItemView;
    }
}
