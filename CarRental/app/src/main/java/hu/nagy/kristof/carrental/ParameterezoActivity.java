package hu.nagy.kristof.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParameterezoActivity extends AppCompatActivity {

    EditText napok;
    TextView napokszama, vegosszeg, emailcim, telefonSzam, berloNeve;
    Button rendelesVeglegesites;
    SharedPreferences sharedPrefUsers, sharedPrefVegosszeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameterezo);
        sharedPrefUsers = getApplicationContext().getSharedPreferences("users", 0);
        sharedPrefVegosszeg = getApplicationContext().getSharedPreferences("vegosszeg",0);


        napok = (EditText)findViewById(R.id.napText);
        napok.setText("1", TextView.BufferType.EDITABLE);
        napok.setInputType(InputType.TYPE_CLASS_NUMBER);
        vegosszeg = (TextView) findViewById(R.id.vegosszegText);
        vegosszeg.setText(String.valueOf(sharedPrefVegosszeg.getInt("osszesen",0)) + " Ft");
        emailcim=(TextView) findViewById(R.id.email);
        emailcim.setText(sharedPrefUsers.getString("email",""));
        telefonSzam=(TextView) findViewById(R.id.telefonszam);
        telefonSzam.setText(sharedPrefUsers.getString("phoneNumber", ""));
        berloNeve=(TextView) findViewById(R.id.nev);
        berloNeve.setText(sharedPrefUsers.getString("name",""));


        rendelesVeglegesites=(Button) findViewById(R.id.orderfinalize);



        rendelesVeglegesites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rendelesVeglegesites.setVisibility(View.INVISIBLE);
                Toast.makeText(ParameterezoActivity.this,"A szalonban átveheti az autót!",Toast.LENGTH_LONG).show();

            }
        });
    }
}
