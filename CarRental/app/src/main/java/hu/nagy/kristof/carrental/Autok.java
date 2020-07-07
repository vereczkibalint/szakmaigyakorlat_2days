package hu.nagy.kristof.carrental;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Autok extends Fragment {
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_autok, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPrefVegosszeg = getContext().getSharedPreferences("vegosszeg", 0);
        suzukiKolcsonzes=(Button)view.findViewById(R.id.suzukiBerles);
        poloKolcsonzes=(Button)view.findViewById(R.id.poloBerles);
        mazdaKolcsonzes=(Button)view.findViewById(R.id.mazdaBerles);
        fordKolcsonzes=(Button)view.findViewById(R.id.fordBerles);

        final Intent intent = new Intent(getActivity(), ParameterezoActivity.class);

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
        cars = JSONParser.fetchCars(getContext());

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
        suzukiBrand = getView().findViewById(R.id.suzukiBrand);
        suzukiModel = getView().findViewById(R.id.suzukiModel);
        suzukiYear = getView().findViewById(R.id.suzukiYear);
        suzukiPriceperday = getView().findViewById(R.id.suzukiPriceperday);
        suzukikolcsonozheto = getView().findViewById(R.id.suzukiKolcsonozheto);

        volkswagenBrand = getView().findViewById(R.id.poloBrand);
        volkswagenModel = getView().findViewById(R.id.poloModel);
        volkswagenYear = getView().findViewById(R.id.poloYear);
        volkswagenPriceperday = getView().findViewById(R.id.poloPriceperday);
        volkswagenkolcsonozheto = getView().findViewById(R.id.poloKolcsonozheto);

        mazdaBrand = getView().findViewById(R.id.mazdaBrand);
        mazdaModel = getView().findViewById(R.id.mazdaModel);
        mazdaYear = getView().findViewById(R.id.mazdaYear);
        mazdaPriceperday = getView().findViewById(R.id.mazdaPriceperday);
        mazdakolcsonozheto = getView().findViewById(R.id.mazdaKolcsonozheto);

        fordBrand = getView().findViewById(R.id.fordBrand);
        fordModel = getView().findViewById(R.id.fordModel);
        fordYear = getView().findViewById(R.id.fordYear);
        fordPriceperday = getView().findViewById(R.id.fordPriceperday);
        fordkolcsonozheto = getView().findViewById(R.id.fordKolcsonozheto);
    }

    protected void setVegosszegPref(int amount){
        SharedPreferences.Editor vegosszegEditor = sharedPrefVegosszeg.edit();
        vegosszegEditor.putInt("osszesen", amount);
        vegosszegEditor.putInt("napiDij", amount);
        vegosszegEditor.apply();
    }
}
