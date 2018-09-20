package com.nitravangla.udgam2k18.Developer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.nitravangla.udgam_2k18.Contacts.Contacts;
import com.nitravangla.udgam_2k18.Events.event.events;
import com.nitravangla.udgam_2k18.MainActivity;
import com.nitravangla.udgam_2k18.R;
import com.nitravangla.udgam_2k18.Sponsers.sponser;
import com.nitravangla.udgam_2k18.about_udgam.udgam;
import com.nitravangla.udgam_2k18.guests.guest;
import com.nitravangla.udgam_2k18.login;

import java.util.Arrays;

public class developer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView lst;
    String[] fruit = {"Prashant Agarwal", "Aman Yadav", "Anshu Priya Jain", "Ravi Mishra", "Kumar Akshay Gupta"};

    String[] desc = {"Project Head & Developer", "Project Head & Developer", "Coordinator & Developer", "Coordinator & Developer", "Developer "};
    Integer[] imgid = {R.drawable.prashant22, R.drawable.aman, R.drawable.anshu, R.drawable.ravi, R.drawable.kuma};
    String[] number = {"7063313688","743944193","8768902827","8436445160","7431944193"};
    String[] rollNumber = {"b160131@nitsikkim.ac.in","b160136@nitsikkim.ac.in","b160092@nitsikkim.ac.in","b160025@nitsikkim.ac.in","b160106@nitsikkim.ac.in"};
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toast.makeText(this, "click",
                Toast.LENGTH_SHORT).show();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_arrow_back_white_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getBackground().setAlpha(122);


        lst = findViewById(R.id.lvMain);

        CustomListview customListview=new CustomListview(this,fruit,desc,imgid);
        lst.setAdapter(customListview);




        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                int k=position;



                MyAlert myalert=new MyAlert(fruit[position], imgid[position], number[position], rollNumber[position]);
                myalert.show(getFragmentManager(),"MyAlert");

            }
        });

    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.load_down_animation, R.anim.load_up_animation);
        }




        else if (id == R.id.nav_contacts) {
            Intent intent = new Intent(this, Contacts.class);

            startActivity(intent);

        }



        else if (id == R.id.nav_events) {
            Intent intent = new Intent(this, events.class);

            startActivity(intent);

        }


        else if (id == R.id.nav_udgam) {
            Intent intent = new Intent(this, udgam.class);

            startActivity(intent);

        }

        else if (id == R.id.nav_guests) {
            Intent intent = new Intent(this, guest.class);

            startActivity(intent);

        }

        else if (id == R.id.nav_sponsers) {
            Intent intent = new Intent(this, sponser.class);

            startActivity(intent);

        }

        else if (id == R.id.nav_exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

        else if(id == R.id.nav_signIn){
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build())).build(), 1000);


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {

            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    Toast.makeText(developer.this, "Successfully Signed In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, login.class);
                    startActivity(intent);


                } else {
                    if (response == null) {
                        Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                        Toast.makeText(this, "No Network", Toast.LENGTH_SHORT).show();

                        return;
                    }

                    if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                        Toast.makeText(this, "unkown Error", Toast.LENGTH_SHORT).show();

                        return;
                    }
                }
            }
        }
    }


}


