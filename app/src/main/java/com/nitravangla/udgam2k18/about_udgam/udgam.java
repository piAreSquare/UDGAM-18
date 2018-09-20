package com.nitravangla.udgam2k18.about_udgam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nitravangla.udgam_2k18.MainActivity;
import com.nitravangla.udgam_2k18.R;

public class udgam extends AppCompatActivity {

   boolean doubleBackToExitPressedOnce=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udgam);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adding back arrow into toolbar
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);


            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
            fab.setImageResource(R.drawable.ic_arrow_back_white_24dp);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { Intent intent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    startActivity(intent);


                }
            });
        }


    }

       //this method is necssary when using toolbar from android.support.v7.widget.Toolbar library

    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }
    public void onBackPressed() {
        super.onBackPressed();
    }

}
