package hu.nagy.kristof.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Autok extends AppCompatActivity {
    ArrayList<Car> cars;

    TextView suzukiBrand;
    TextView suzukiModel;
    TextView suzukiYear;
    TextView suzukiPriceperday;
    TextView suzukikolcsonozheto;

    TextView mazdaBrand;
    TextView mazdaModel;
    TextView mazdaYear;
    TextView mazdaPriceperday;
    TextView mazdakolcsonozheto;

    TextView volkswagenBrand;
    TextView volkswagenModel;
    TextView volkswagenYear;
    TextView volkswagenPriceperday;
    TextView volkswagenkolcsonozheto;



    TextView fordBrand;
    TextView fordModel;
    TextView fordYear;
    TextView fordPriceperday;
    TextView fordkolcsonozheto;

    SharedPreferences sharedPrefVegosszeg;

    Button suzukiKolcsonzes, poloKolcsonzes, mazdaKolcsonzes, fordKolcsonzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autok);

        sharedPrefVegosszeg = getApplicationContext().getSharedPreferences("vegosszeg", 0);

        suzukiKolcsonzes=(Button)findViewById(R.id.suzukiBerles);
        poloKolcsonzes=(Button)findViewById(R.id.poloBerles);
        mazdaKolcsonzes=(Button)findViewById(R.id.mazdaBerles);
        fordKolcsonzes=(Button)findViewById(R.id.fordBerles);

        final Intent intent = new Intent(Autok.this,ParameterezoActivity.class);

        suzukiKolcsonzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int osszeg = Integer.parseInt(suzukiPriceperday.getText().toString().split("Ft")[0]);
                setVegosszegPref(osszeg);
                startActivity(intent);
            }
        });

        poloKolcsonzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int osszeg = Integer.parseInt(volkswagenPriceperday.getText().toString().split("Ft")[0]);
                setVegosszegPref(osszeg);
                startActivity(intent);
            }
        });

        mazdaKolcsonzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int osszeg = Integer.parseInt(mazdaPriceperday.getText().toString().split("Ft")[0]);
                setVegosszegPref(osszeg);
                startActivity(intent);
            }
        });

        fordKolcsonzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int osszeg = Integer.parseInt(fordPriceperday.getText().toString().split("Ft")[0]);
                setVegosszegPref(osszeg);
                startActivity(intent);
            }
        });

        loadTextViews();
        cars = JSONParser.fetchCars(Autok.this);

        for(Car c : cars) {
            switch (c.getBrand()) {
                case "Suzuki":
                    suzukiBrand.setText(c.getBrand());
                    suzukiModel.setText(c.getModel());
                    suzukiYear.setText(c.getYear().toString());
                    suzukiPriceperday.setText(c.getPricePerDay().toString() + "Ft / nap");
                    break;
                case "Mazda":
                    mazdaBrand.setText(c.getBrand());
                    mazdaModel.setText(c.getModel());
                    mazdaYear.setText(c.getYear().toString());
                    mazdaPriceperday.setText(c.getPricePerDay().toString() + "Ft / nap");
                    break;
                case "Volkswagen":
                    volkswagenBrand.setText(c.getBrand());
                    volkswagenModel.setText(c.getModel());
                    volkswagenYear.setText(c.getYear().toString());
                    volkswagenPriceperday.setText(c.getPricePerDay().toString() + "Ft / nap");
                    break;
                case "Ford":
                    fordBrand.setText(c.getBrand());
                    fordModel.setText(c.getModel());
                    fordYear.setText(c.getYear().toString());
                    fordPriceperday.setText(c.getPricePerDay().toString() + "Ft / nap");
                    break;

            }
        }
    }

    private void loadTextViews(){
        suzukiBrand = (TextView)findViewById(R.id.suzukiBrand);
        suzukiModel = (TextView)findViewById(R.id.suzukiModel);
        suzukiYear = (TextView)findViewById(R.id.suzukiYear);
        suzukiPriceperday = (TextView)findViewById(R.id.suzukiPriceperday);
        suzukikolcsonozheto = (TextView)findViewById(R.id.suzukiKolcsonozheto);

        volkswagenBrand = (TextView)findViewById(R.id.poloBrand);
        volkswagenModel = (TextView)findViewById(R.id.poloModel);
        volkswagenYear = (TextView)findViewById(R.id.poloYear);
        volkswagenPriceperday = (TextView)findViewById(R.id.poloPriceperday);
        volkswagenkolcsonozheto = (TextView)findViewById(R.id.poloKolcsonozheto);

        mazdaBrand = (TextView)findViewById(R.id.mazdaBrand);
        mazdaModel = (TextView)findViewById(R.id.mazdaModel);
        mazdaYear = (TextView)findViewById(R.id.mazdaYear);
        mazdaPriceperday = (TextView)findViewById(R.id.mazdaPriceperday);
        mazdakolcsonozheto = (TextView)findViewById(R.id.mazdaKolcsonozheto);

        fordBrand = (TextView)findViewById(R.id.fordBrand);
        fordModel = (TextView)findViewById(R.id.fordModel);
        fordYear = (TextView)findViewById(R.id.fordYear);
        fordPriceperday = (TextView)findViewById(R.id.fordPriceperday);
        fordkolcsonozheto = (TextView)findViewById(R.id.fordKolcsonozheto);
    }

    protected void setVegosszegPref(int amount){
        SharedPreferences.Editor vegosszegEditor = sharedPrefVegosszeg.edit();
        vegosszegEditor.putInt("osszesen", amount);
        vegosszegEditor.putInt("napiDij", amount);
        vegosszegEditor.apply();
    }
}
