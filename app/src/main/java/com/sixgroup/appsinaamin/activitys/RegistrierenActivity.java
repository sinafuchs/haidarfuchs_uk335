package com.sixgroup.appsinaamin.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sixgroup.appsinaamin.R;

public class RegistrierenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);
    }

    public void goToFotohochladen (View view){
        Intent intent = new Intent (this, FotohochladenActivity.class);
        startActivity(intent);
    }

    public void goToLogin (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

}
