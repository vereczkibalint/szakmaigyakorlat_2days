package hu.nagy.kristof.carrental;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button singUpButton;
    EditText email, phoneNumber, name;
    SharedPreferences sharedPrefUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singUpButton=(Button)findViewById(R.id.buttonSignUp);
        email = (EditText) findViewById(R.id.editTextEmail);
        phoneNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
        name = (EditText)findViewById(R.id.editTextName);
        sharedPrefUsers = getApplicationContext().getSharedPreferences("users", 0);
        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkForEmptyData()){
                    Toast.makeText(MainActivity.this, "Minden mező kitöltése kötelező!", Toast.LENGTH_LONG).show();
                }else if(checkForInvalidEmail()){
                    Toast.makeText(MainActivity.this, "Hibás email formátum!", Toast.LENGTH_LONG).show();
                }else if(checkForInvalidPhoneNumber()){
                    Toast.makeText(MainActivity.this, "Hibás telefonszám formátum!", Toast.LENGTH_LONG).show();
                }else {
                    setUserDataPrefs();
                    loadHomeActivity();
                }
            }
        });
        if(sharedPrefUsers.getString("name", "") != ""){
            loadHomeActivity();
        }
    }

    protected void loadHomeActivity(){
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }

    protected boolean checkForEmptyData(){
        return TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(phoneNumber.getText().toString()) || TextUtils.isEmpty(name.getText().toString());
    }

    protected boolean checkForInvalidEmail(){
        return !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches();
    }

    protected boolean checkForInvalidPhoneNumber(){
        return !phoneNumber.getText().toString().matches("\\+36[0-9]{9}");
    }

    protected void setUserDataPrefs(){
        SharedPreferences.Editor userPrefEditor = sharedPrefUsers.edit();
        userPrefEditor.putString("email", email.getText().toString());
        userPrefEditor.putString("phoneNumber", phoneNumber.getText().toString());
        userPrefEditor.putString("name", name.getText().toString());
        userPrefEditor.apply();
    }
}
