package com.nitravangla.udgam2k18.guests;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.nitravangla.udgam_2k18.MainActivity;
import com.nitravangla.udgam_2k18.R;

public class guest extends AppCompatActivity {
    ViewPager viewpager;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setImageResource(R.drawable.ic_arrow_back_white_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(intent);

            }
        });


        Toast.makeText(this, "swipe left",
                Toast.LENGTH_SHORT).show();

        viewpager = (ViewPager) findViewById(R.id.pager);

        PagerAdapter padptr = new PagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(padptr);
    }

    public void onBackPressed() {

        super.onBackPressed();
    }
}
