package hu.nagy.kristof.carrental;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Contacts extends Fragment {

    private TextView textView_fblink;
    Button NagyKristof;
    Button BalintZoltan;
    Button GulyasPeter;
    Button BaloghDani;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contacts, container, false);
        NagyKristof=(Button)view.findViewById(R.id.nagykristofButton);
        BalintZoltan=(Button)view.findViewById(R.id.balintButton);
        GulyasPeter=(Button)view.findViewById(R.id.petyusButton);
        BaloghDani=(Button)view.findViewById(R.id.daniButton);



        final Intent intentKristof = new Intent(getActivity(),NagyK.class);
        final Intent intentBalint = new Intent(getActivity(),VereczkiB.class);
        final Intent intentPetyus = new Intent(getActivity(),GulyasP.class);
        final Intent intentDani = new Intent(getActivity(),BaloghD.class);




        NagyKristof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentKristof);
            }
        });

        BalintZoltan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentBalint);
            }
        });

        GulyasPeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPetyus);
            }
        });

        BaloghDani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDani);
            }
        });

        return view;
    }


}

