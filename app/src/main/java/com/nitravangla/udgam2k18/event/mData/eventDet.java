package com.nitravangla.udgam2k18.event.mData;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nitravangla.udgam_2k18.R;

/**
 * Created by root on 28/3/18.
 */

public class eventDet extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    String name;

    Button b1;
    TextView title_tv, desc_tv, venue1, date1, time1, Nu1, Nu2, entryFees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_description);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        init();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        b1 = (Button) findViewById(R.id.button);
        name = getIntent().getStringExtra("event_name");
        String desc = getIntent().getStringExtra("event_desc");
        String ven = getIntent().getStringExtra("event_venue");
        String dat = getIntent().getStringExtra("event_date");
        String tim = getIntent().getStringExtra("event_time");
        String nu1 = getIntent().getStringExtra("event_nu1");
        String nu2 = getIntent().getStringExtra("event_nu2");
        String ent = getIntent().getStringExtra("event_Fee");


        setTitle(name);
        setSupportActionBar(toolbar);
        toolbar.setTitle("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //title_tv.setText(name);
        desc_tv.setText(desc);
        venue1.setText(ven);
        date1.setText(dat);
        time1.setText(tim);

        Nu1.setText(nu1);
        Nu2.setText(nu2);
        entryFees.setText(ent);
        b1.setOnClickListener(this);


        Toast.makeText(getApplicationContext(), "" + name, Toast.LENGTH_SHORT).show();
    }


    public void init() {
        // title_tv = (TextView)findViewById(R.id.header_event);
        desc_tv = (TextView) findViewById(R.id.desc_event);
        venue1 = (TextView) findViewById(R.id.Venue);
        date1 = (TextView) findViewById(R.id.date);
        time1 = (TextView) findViewById(R.id.Time);
        Nu1 = (TextView) findViewById(R.id.nu1);
        Nu2 = (TextView) findViewById(R.id.nu2);
        entryFees = (TextView) findViewById(R.id.entryFee);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if (firebaseAuth.getCurrentUser() != null) {
/*            FirebaseUser user=firebaseAuth.getCurrentUser();

            databaseReference.child(user.getPhoneNumber()).push().setValue(name);*/

           saveInUser(name);
           saveInEvent(name);

        } else {
            //open the signup/signin dialog

            Toast.makeText(getApplicationContext(),"Please sign in first",Toast.LENGTH_SHORT).show();
        }
    }

    public void saveInUser(String name){
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db = db.child("user");
        db = db.child(""+FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
        db = db.push();
        db.setValue(name)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //success
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // failure

                    }
                });
    }

    public void saveInEvent(String eventName){
        eventName = eventName.replace(" ","");
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db = db.child("events");
        db = db.child(""+eventName);
        db = db.child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        db.setValue(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

}
