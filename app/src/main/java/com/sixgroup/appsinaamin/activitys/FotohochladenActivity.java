package com.sixgroup.appsinaamin.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.activitys.LoggedinActivity;

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
