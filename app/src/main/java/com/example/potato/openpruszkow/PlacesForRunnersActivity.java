package com.example.potato.openpruszkow;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Potato with sour cream and salt on 03.10.2017.
 */

public class PlacesForRunnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.places_list);

        // To allow Up navigation with the app icon in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ArrayList of places for runners
        ArrayList<Place> placesForRunnersList = new ArrayList<>();

        // First place
        //
        // Pictures  ids for za_basenem place
        int[] zaBasenemPicturesArray = {R.drawable.za_basenem_1, R.drawable.za_basenem_2,
                R.drawable.za_basenem_3, R.drawable.za_basenem_4, R.drawable.za_basenem_5,
                R.drawable.za_basenem_6, R.drawable.za_basenem_7, R.drawable.za_basenem_8,
                R.drawable.za_basenem_9};

        // Coordinates
        double[] coordinatesZaBasenem = {52.162451, 20.823317};
        placesForRunnersList.add(new Place(R.drawable.za_basenem_1, getResources().getString(R.string.za_basenem),
                getResources().getString(R.string.za_basenem_description), coordinatesZaBasenem, zaBasenemPicturesArray));


        // Second place
        //
        // Pictures  ids for Komorów place
        int[] komorowPicturesArray = {R.drawable.komorow_1, R.drawable.komorow_2};

        // Coordinates
        double[] coordinatesKomorow = {52.162451, 20.823317};
        placesForRunnersList.add(new Place(R.drawable.komorow_1, getResources().getString(R.string.komorow),
                getResources().getString(R.string.komorów_description), coordinatesKomorow, komorowPicturesArray));

        // Third place
        //
        // Coordinates
        double[] coordinatesStadionMOS = {52.162451, 20.823317};
        placesForRunnersList.add(new Place(R.drawable.places_runners_stadion_mos, getResources().getString(R.string.stadion_mos),
                getResources().getString(R.string.stadion_mos_description), coordinatesStadionMOS, (int[]) null));


        // Adapter knows how to create list items for each item in the list.
        PlaceAdapter itemsAdapter = new PlaceAdapter(this, placesForRunnersList);

        // Find the ListView object in the view hierarchy with the view ID called list.
        ListView listView = (ListView) findViewById(R.id.list);

        //setting background color for ListView
        listView.setBackgroundColor(ContextCompat.getColor(this, R.color.lightBlueBackground));

        // Make the found previously ListVew use the PlaceAdapter we created above, so that the
        // ListView will display list items for each ListView item in the list.
        listView.setAdapter(itemsAdapter);
    }
}
