package com.sixgroup.appsinaamin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FotohochladenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotohochladen);
    }

    public void goToLogedin (View view){
        Intent intent = new Intent (this, LoggedinActivity.class);
        startActivity(intent);
    }
}
