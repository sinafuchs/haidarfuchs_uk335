package com.sixgroup.appsinaamin.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;

public class RegistrierenActivity extends AppCompatActivity {

    //on create method starts activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);
    }

    //changes activity to "a"ctivity_fotohochladen"
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

        intent.putExtra(getString(R.string.editTextVorname), firstName.getText().toString());
        intent.putExtra(getString(R.string.editTextNachname), lastName.getText().toString());
        intent.putExtra(getString(R.string.editTextEmail), email.getText().toString());
        intent.putExtra(getString(R.string.editTextPassword), password.getText().toString());
    }

}
