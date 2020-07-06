package hu.nagy.kristof.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class ParameterezoActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    TextView vegosszeg, emailcim, telefonSzam, berloNeve;
    NumberPicker napok;
    Button rendelesVeglegesites;
    SharedPreferences sharedPrefUsers, sharedPrefVegosszeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameterezo);
        sharedPrefUsers = getApplicationContext().getSharedPreferences("users", 0);
        sharedPrefVegosszeg = getApplicationContext().getSharedPreferences("vegosszeg",0);


        napok = (NumberPicker)findViewById(R.id.napText);
        napok.setValue(1);
        napok.setMinValue(1);
        napok.setMaxValue(7);
        napok.setOnValueChangedListener(this);
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

    protected void updateSharedPrefVegosszeg(int amount){
        SharedPreferences.Editor vegosszegEditor = sharedPrefVegosszeg.edit();
        vegosszegEditor.putInt("osszesen", amount);
        vegosszegEditor.apply();
        updateVegosszegTextView();
    }

    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        int napiDij = sharedPrefVegosszeg.getInt("napiDij",0);
        int ujDij = picker.getValue() * napiDij;

        updateSharedPrefVegosszeg(ujDij);
    }

    protected void updateVegosszegTextView(){
        vegosszeg.setText(String.valueOf(sharedPrefVegosszeg.getInt("osszesen",0)));
    }
}
