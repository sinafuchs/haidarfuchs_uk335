package com.sixgroup.appsinaamin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewZuRegistrieren = findViewById(R.id.textViewzuRegistrieren);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToRegistrieren (View view){
        Intent intent = new Intent (this, RegistrierenActivity.class);
        startActivity(intent);
    }
}
