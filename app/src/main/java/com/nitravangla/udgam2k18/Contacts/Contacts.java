package com.nitravangla.udgam2k18.Contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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
import com.nitravangla.udgam_2k18.Developer.developer;
import com.nitravangla.udgam_2k18.Events.event.events;
import com.nitravangla.udgam_2k18.MainActivity;
import com.nitravangla.udgam_2k18.R;
import com.nitravangla.udgam_2k18.Sponsers.sponser;
import com.nitravangla.udgam_2k18.about_udgam.udgam;
import com.nitravangla.udgam_2k18.gallery.gallery;
import com.nitravangla.udgam_2k18.guests.guest;
import com.nitravangla.udgam_2k18.login;

import java.util.Arrays;

public class Contacts extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView lst;
    String[] fruit = {"Mr. MD Sarfaraj Alam ","Dr. Sayantan Mandal","Dr Pranab Kundu", "Dr. Dhananjay Tripathi ","Sourav Singh Rathore", "Gaurav Kumar", "Abisek Dahal", "Meeraj Ahmad","Supriyo Banarjee","Deepak Prasad","Anshu Priya Jain","Prashant Agarwal","Ravi Mishra","Aman Yadav","Mohit Dutt Mathur","Pranesh","Mayank Josi","Bimal Gautam","Prateek Sharma","Divyanshi Verma" ,"Diksha Soni","Rishabh Mishra","Mithun Singh","Aksheeta","Hema","Prena Tamang","Nim Lhamu Tmang","Manish Kumar","Priyanka","Suraj Kumar Giri","Prince Raj","Dezong Lepcha","Diwakar Sharma","Soni Reshmi","Pritam","Sandeep","Jahir","Anjum","Goverdhan","Aditi Anupam","Bittu Jaiswal","Snehal M Panchal","Koshik Singh","Prasun Kumar","Vivek Kumar","K.Sai Lakshman","Rinzing Bhutia","Narbada","Sanyam Chauhan"};

    String[] desc = {"Convenor","Co-Convenor","Faculty Advisor","Faculty Advisor", "President", "Vice-President", "Secretary", "Joint Secretary ","Website(Coordinator)","Website(Coordinator)","App(Coordinator)","App(Coordinator)","App(Coordinator)","Publicity(Coordinator)","Publicity(Coordinator)","Publicity(Coordinator)","Technical(Coordinator)","Technical(Coordinator)","Technical(Coordinator)","Event(Coordinator)","Event(Coordinator)","Event(Coordinator)","Event(Coordinator)","Cultural(Coordinator)","Cultural(Coordinator)","Cultural(Coordinator)","Hospitality(Coordinator)","Hospitality(Coordinator)","Sponsership(Coordinator)","Sponsership(Coordinator)","Sponsership(Coordinator)","Sponsership(Coordinator)","Sponsership(Coordinator)","Creativity(Coordinator)","Creativity(Coordinator)","Creativity(Coordinator)","Creativity(Coordinator)","Content(Coordinator)","Content(Coordinator)","Procurement(Coordinator)","Procurement(Coordinator)","Wind Up(Coordinator)","Wind Up(Coordinator)","Wind Up(Coordinator)","Wind Up(Coordinator)","Accounts(Coordinator)","Accounts(Coordinator)","Merchandise(Coordinator)","Merchandise(Coordinator)"};
    Integer[] imgid = {R.drawable.alam,R.drawable.sayantan,R.drawable.pranab,R.drawable.dt, R.drawable.sourav, R.drawable.gaurav, R.drawable.abisek, R.drawable.meeraj,R.drawable.supriyo, R.drawable.deepak , R.drawable.anshu, R.drawable.prashant22, R.drawable.ravi,R.drawable.aman,R.drawable.mohit,R.drawable.pranesh,R.drawable.mayank,R.drawable.bimal,R.drawable.prateek,R.drawable.divyanshi,R.drawable.diksha,R.drawable.rishab,R.drawable.mithun,R.drawable.aksheeta,R.drawable.hema2,R.drawable.prena,R.drawable.nim,R.drawable.manish,R.drawable.priyanka,R.drawable.suraj,R.drawable.prince,R.drawable.dezong,R.drawable.diwakar,R.drawable.soni,R.drawable.pritam,R.drawable.sandeep,R.drawable.jahir,R.drawable.anjum2,R.drawable.govardhan,R.drawable.aditi,R.drawable.bittu,R.drawable.snehal,R.drawable.kaushik,R.drawable.prasun,R.drawable.vivek,R.drawable.laksman,R.drawable.rinz,R.drawable.narbada,R.drawable.sanyam};
    String[] number = {"9332342995","8016118004","9433887700","9475693775","9635044901","9472968512","9749350655","9732040925","7501118915","8972113084","8768902827","7063313688","8436445160","7431944193","9474474270","9593110144","8436445325","8348145270","9002171908","7478293335","7872663667","7076263915","7718291219","7478165915","8436130137","7872253789","7363821098","8371034023","7076014856","9547840263","7478165929","9547644367","7478165914","8373065298","8436486557","8906713946","8967734880","8016142226","8936832422","7076252336","7076455854","8967048167","7501824564","7274926212","7431941029","7794059444","9775920505","8906257109","8972117473"};
    String[] rollNumber = {"mdsarfarajalam@gmail.com","sayantan@nitsikkim.ac.in","pranab@nitsikkim.ac.in","dhananjaystripathi9@gmail.com","b140041@nitsikkim.ac.in","B150139@nitsikkim.ac.in","b160022@nitsikkim.ac.in","B160028@nitsikkim.ac.in","B160012@nitsikkim.ac.in","B160026@nitsikkim.ac.in","B160092@nitsikkim.ac.in","b160131@nitsikkim.ac.in","B160025@nitsikkim.ac.in","B160136@nitsikkim.ac.in","B160003@nitsikkim.ac.in","B160103@nitsikkim.ac.in","B160024@nitsikkim.ac.in","B160037@nitsikkim.ac.in","B160118@nitsikkim.ac.in","B160062@nitsikkim.ac.in","B160132@nitsikkim.ac.in","B160052@nitsikkim.ac.in","B160049@nitsikkim.ac.in","B160032@nitsikkim.ac.in","B160070@nitsikkim.ac.in","B160084@nitsikkim.ac.in","B160010@nitsikkim.ac.in","B160136@nitsikkim.ac.in","B160083@nitsikkim.ac.in","B160008@nitsikkim.ac.in","B160088@nitsikkim.ac.in","B160099@nitsikkim.ac.in","B160069nitsikkim.ac.in","b160113@nitsikkim.ac.in","b160069@nitsikkim.ac.in","B160061@nitsikkim.ac.in","B160031@nitsikkim.ac.in","B160055@nitsikkim.ac.in","B160085@nitsikkim.ac.in","B160075@nitsikkim.ac.in","B160040@nitsikkim.ac.in","B160029@nitsikkim.ac.in","B160050@nitsikkim.ac.in","b160004@nitsikkim.ac.in","B160130@nitsikkim.ac.in","B160122@nitsikkim.ac.in","B160019@nitsikkim.ac.in","B160005@nitsikkim.ac.in","B160114@nitsikkim.ac.in","B160051@nitsikkim.ac.in"};

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
            overridePendingTransition(R.anim.load_down_animation,R.anim.load_up_animation);
        }




         else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, gallery.class);

            startActivity(intent);

        }



        else if (id == R.id.nav_events) {
            Intent intent = new Intent(this, events.class);

            startActivity(intent);

        }

        else if (id == R.id.nav_developer) {
            Intent intent = new Intent(this, developer.class);

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




        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {

            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    Toast.makeText(Contacts.this, "Successfully Signed In", Toast.LENGTH_SHORT).show();
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



