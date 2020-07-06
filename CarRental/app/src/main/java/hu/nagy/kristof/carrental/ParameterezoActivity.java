package hu.nagy.kristof.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParameterezoActivity extends AppCompatActivity {

    EditText napok;
    TextView napokszama, vegosszeg, emailcim, telefonSzam, berloNeve;
    Button rendelesVeglegesites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameterezo);


        napok = (EditText)findViewById(R.id.napText);
        vegosszeg = (TextView) findViewById(R.id.vegosszegText);
        emailcim=(TextView) findViewById(R.id.email);
        telefonSzam=(TextView) findViewById(R.id.telefonszam);
        berloNeve=(TextView) findViewById(R.id.nev);

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
