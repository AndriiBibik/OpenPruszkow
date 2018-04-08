package com.example.potato.openpruszkow;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.places_list);

        // To allow Up navigation with the app icon in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // ArrayList of Parks
        ArrayList<Place> parksList = new ArrayList<>();


        // Adding each park to ArrayList

        // Anielin
        double[] coordinates = {52.168772, 20.807641};
        parksList.add(new Place(R.drawable.main_image_park_anielin,
                getBaseContext().getString(R.string.park_anielin),
                getBaseContext().getString(R.string.park_anielin_description), coordinates, (int[]) null));
        Log.v("" + coordinates[0], "" + coordinates[1]);

        // Kosciuszki
        coordinates[0] = 52.166663;
        coordinates[1] = 20.802053;
        parksList.add(new Place(R.drawable.main_image_park_kosciuszki,
                getBaseContext().getString(R.string.park_kosciuszki),
                getBaseContext().getString(R.string.park_kosciuszki_description), coordinates, (int[]) null));

        // Mazowsze
        coordinates[0] = 52.184372;
        coordinates[1] = 20.802114;
        parksList.add(new Place(R.drawable.main_image_park_mazowsze,
                getBaseContext().getString(R.string.park_mazowsze),
                getBaseContext().getString(R.string.park_mazowsze_description), coordinates, (int[]) null));

        // Potulickich
        coordinates[0] = 52.167423;
        coordinates[1] = 20.809584;
        // array of additional images ids
        int[] picsPotulickich = {R.drawable.park_potulickich_1, R.drawable.park_potulickich_2,
                R.drawable.park_potulickich_3, R.drawable.park_potulickich_4};
        parksList.add(new Place(R.drawable.main_image_park_potulickich,
                getBaseContext().getString(R.string.park_potulickich),
                getBaseContext().getString(R.string.park_potulickich_description), coordinates, picsPotulickich));


        // Zwirowisko
        coordinates[0] = 52.151482;
        coordinates[1] = 20.796470;
        parksList.add(new Place(R.drawable.main_image_park_zwirowisko,
                getBaseContext().getString(R.string.park_zwirowisko),
                getBaseContext().getString(R.string.park_zwirowisko_description), coordinates, (int[]) null));


        // adapter knows how to create list items for each item in the list.
        PlaceAdapter itemsAdapter = new PlaceAdapter(this, parksList);

        // Find the ListView object in the view hierarchy with the view ID called list.
        ListView listView = (ListView) findViewById(R.id.list);

        //setting background color for ListView
        listView.setBackgroundColor(ContextCompat.getColor(this, R.color.lightGreenBackground));

        // Make the found previously ListVew use the PlaceAdapter we created above, so that the
        // ListView will display list items for each ListView item in the list.
        listView.setAdapter(itemsAdapter);
    }
}
