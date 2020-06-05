package com.sixgroup.appsinaamin.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;

public class RegistrierenActivity extends AppCompatActivity {

    //public Button buttonRegistrieren = findViewById(R.id.buttonRegistrieren);;

    //on create method starts activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);


        //buttonRegistrieren.setEnabled(false);
    }

    //changes activity to "activity_fotohochladen"
    public void goToFotohochladen (View view){
        Intent intent = new Intent (this, FotohochladenActivity.class);
        getData(intent);
        startActivity(intent);
    }

    //changes activity to "activity_main"
    public void goToLogin (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void getData (Intent intent) {
        EditText firstName = findViewById(R.id.editTextVorname);
        EditText lastName = findViewById(R.id.editTextNachname);
        EditText email = findViewById(R.id.editTextEmailRegistrieren);
        EditText password = findViewById(R.id.editTextPasswortRegistrieren);
        EditText passwordConfirm = findViewById(R.id.editTextPasswortBestaetigen);

        String firstnameString = firstName.getText().toString();
        String lastnameString = lastName.getText().toString();
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();

        if (validateName(firstnameString) && validateName(lastnameString)) {

            //buttonRegistrieren.setEnabled(false);
            intent.putExtra(getString(R.string.editTextVorname), firstnameString);
            intent.putExtra(getString(R.string.editTextNachname), lastnameString);
            intent.putExtra(getString(R.string.editTextEmail), emailString);
            intent.putExtra(getString(R.string.editTextPassword), "" + passwordString.hashCode());
        }
    }


    public boolean validateName(String name){

        Context context = getApplicationContext();

        if (name.trim().length() > 51) {
            Toast toast = Toast.makeText(context, name + " ist zu lange. Der Name darf nur 50 Zeichen lang sein.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return false;
        } else if (name.trim().length() == 0) {
            Toast toast = Toast.makeText(context, "Feld ist leer, geben Sie bitte etwas ein", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return false;
        } else {
            return true;
        }
    }
}
