package hu.nagy.kristof.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaloghD extends AppCompatActivity {

    Button facebookgomb;
    Button gmailgomb;
    Button phonegomb;
    Button tovabb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balogh_d);

        facebookgomb = (Button)findViewById(R.id.fb);
        gmailgomb = (Button)findViewById(R.id.gmail);
        phonegomb = (Button)findViewById(R.id.phone);

        facebookgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri facebookuri = Uri.parse("https://www.facebook.com/search/top?q=%C4%91%C3%A1niel%20balogh");
                Intent facebook = new Intent(Intent.ACTION_VIEW,facebookuri);
                startActivity(facebook);
            }
        });

        gmailgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent emailintent = new Intent(Intent.ACTION_SENDTO);
               emailintent.setType("text/html");
               emailintent.setData(Uri.parse("mailto:danikapus97@gmail.com"));
               emailintent.putExtra(Intent.EXTRA_EMAIL,"danikapus97@gmail.com");
               emailintent.putExtra(Intent.EXTRA_SUBJECT,"Segítséget kérek");
               emailintent.putExtra(Intent.EXTRA_TEXT,"Kérem segítsen");
               startActivity(emailintent);
            }
        });

        phonegomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri pn = Uri.parse("tel:06203602101");
                Intent phoneintent = new Intent(Intent.ACTION_DIAL,pn);
                startActivity(phoneintent);
            }
        });



    }
}
