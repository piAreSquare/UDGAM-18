package com.nitravangla.udgam2k18.Sponsers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nitravangla.udgam_2k18.R;

import java.util.ArrayList;

public class sponser extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelSponser> sponsersList;
    boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponser);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.recycler_view);

        sponsersList = new ArrayList<>();

        sponsersList.add(new ModelSponser(R.drawable.maruti, "Maruti Suzuki", "gold Soponser"));
        sponsersList.add(new ModelSponser(R.drawable.sbi, "SBI", "Silver Sponser"));
        sponsersList.add(new ModelSponser(R.drawable.chulyang, "Chulyang", "Silver Sponser"));
        sponsersList.add(new ModelSponser(R.drawable.cyber, "Cybercure", "Silver Sponser"));
        sponsersList.add(new ModelSponser(R.drawable.indosaw, "Indosaw", "Silver Sponser"));
        sponsersList.add(new ModelSponser(R.drawable.mandala, "Hotel Mandala", "Silver Sponser"));
        sponsersList.add(new ModelSponser(R.drawable.ravanglastar, "Hotel RavanglaStar", "Silver Sponser"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rlmanager = linearLayoutManager;
        recyclerView.setLayoutManager(rlmanager);

        FoodSponser adapter = new FoodSponser(this, sponsersList);

        recyclerView.setAdapter(adapter);
    }


    public void onBackPressed() {

        super.onBackPressed();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
