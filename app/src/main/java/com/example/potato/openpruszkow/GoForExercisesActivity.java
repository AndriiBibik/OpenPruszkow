package com.example.potato.openpruszkow;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class GoForExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.places_list);

        // To allow Up navigation with the app icon in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Place> placesForExercises = new ArrayList<>();

        // Place for exercises Plac w parku Kosciuszki
        //
        // Coordinates
        double[] coordinatesPlacKosciuszki = {52.162451, 20.823317};

        placesForExercises.add(new Place(R.drawable.exercises_kosciuszki, this.getString(R.string.plac_park_kosciuszki),
                this.getString(R.string.plac_park_kosciuszki_description), coordinatesPlacKosciuszki, (int[]) null));

        // Place for exercises w parku Anielin
        //
        // Coordinates
        double[] coordinatesPlacParkAnielin = {52.162451, 20.823317};

        placesForExercises.add(new Place(R.drawable.places_exercises_park_anielin, this.getString(R.string.czwiczenia_park_anielin),
                this.getString(R.string.czwiczenia_park_anielin_description), coordinatesPlacParkAnielin, (int[]) null));

        // Place for exercises plac do wourkout'u
        //
        // Coordinates
        double[] coordinatesPlacDoWorkout = {52.162451, 20.823317};

        placesForExercises.add(new Place(R.drawable.places_exercises_workout, this.getString(R.string.street_wourkout),
                this.getString(R.string.street_workout_description), coordinatesPlacDoWorkout, (int[]) null));

        // Place for exercises miejsce do zagrania w Plazowke
        //
        // Coordinates
        double[] coordinatesPlazowka = {52.162451, 20.823317};

        placesForExercises.add(new Place(R.drawable.places_exercises_plazowka, this.getString(R.string.place_exercises_plazowka),
                this.getString(R.string.place_exercises_plazowka_description), coordinatesPlazowka, (int[]) null));

        // Place for exercises basen Kapry
        //
        // Coordinates
        double[] coordinatesKapry = {52.162451, 20.823317};

        placesForExercises.add(new Place(R.drawable.places_for_exercises_basen_kapry, this.getString(R.string.place_exercises_basen_kapry),
                this.getString(R.string.place_exercises_plazowka_description), coordinatesPlazowka, (int[]) null));


        // adapter knows how to create list items for each item in the list.
        PlaceAdapter itemsAdapter = new PlaceAdapter(this, placesForExercises);

        // Find the ListView object in the view hierarchy with the view ID called list.
        ListView listView = (ListView) findViewById(R.id.list);

        //setting background color for ListView
        listView.setBackgroundColor(ContextCompat.getColor(this, R.color.lightDeepOrangeBackground));

        // Make the found previously ListVew use the PlaceAdapter we created above, so that the
        // ListView will display list items for each ListView item in the list.
        listView.setAdapter(itemsAdapter);
    }
}
