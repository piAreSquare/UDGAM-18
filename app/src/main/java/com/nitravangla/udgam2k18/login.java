package com.nitravangla.udgam2k18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {
    private Button button;
    private EditText editText_name;
    private EditText editText_roll;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        editText_name=(EditText) findViewById(R.id.userName);
        editText_roll=(EditText)findViewById(R.id.roll_num);
        button=(Button)findViewById(R.id.buttonS);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user=mAuth.getCurrentUser();
                String name=editText_name.getText().toString();
                String roll=editText_roll.getText().toString();

                databaseReference.child(user.getPhoneNumber()).child("Name").setValue(name);
                databaseReference.child(user.getPhoneNumber()).child("Roll Num").setValue(roll);

                Toast.makeText(login.this, "Submitted Sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();

                startActivity(intent);
            }
        });



    }
}
