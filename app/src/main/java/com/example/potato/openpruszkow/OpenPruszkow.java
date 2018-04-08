package com.example.potato.openpruszkow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class OpenPruszkow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_open_pruszkow);


        //Finding parks LinearLayout to set onClickListener
        LinearLayout parks = (LinearLayout) findViewById(R.id.parks);

        // setting onClickListener to go to corresponding Activity
        parks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a new intent to open corresponding Activity
                Intent parksIntent = new Intent(OpenPruszkow.this, ParksActivity.class);

                // starting new activity
                startActivity(parksIntent);
            }
        });


        //Finding "places_for_runners" LinearLayout to set onClickListener
        LinearLayout placesRunners = (LinearLayout) findViewById(R.id.places_for_runners);

        // setting onClickListener to go to corresponding Activity
        placesRunners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a new intent to open corresponding Activity
                Intent plForRunnersIntent = new Intent(OpenPruszkow.this, PlacesForRunnersActivity.class);

                // starting new activity
                startActivity(plForRunnersIntent);
            }
        });


        //Finding "exercises" LinearLayout to set onClickListener
        LinearLayout exercises = (LinearLayout) findViewById(R.id.exercises);

        // setting onClickListener to go to corresponding Activity
        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a new intent to open corresponding Activity
                Intent exercisesIntent = new Intent(OpenPruszkow.this, GoForExercisesActivity.class);

                // starting new activity
                startActivity(exercisesIntent);
            }
        });


        //Finding "eat_fun" LinearLayout to set onClickListener
        LinearLayout eatFun = (LinearLayout) findViewById(R.id.eat_fun);

        // setting onClickListener to go to corresponding Activity
        eatFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a new intent to open corresponding Activity
                Intent eatFunIntent = new Intent(OpenPruszkow.this, EatFunActivity.class);

                // starting new activity
                startActivity(eatFunIntent);
            }
        });
    }
}
