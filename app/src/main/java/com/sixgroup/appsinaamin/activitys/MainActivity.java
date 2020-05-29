package com.sixgroup.appsinaamin.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.AppDatabase;
import com.sixgroup.appsinaamin.persistence.UserDao;

public class MainActivity extends AppCompatActivity {

    //creates activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       UserDao userDao = AppDatabase.getAppDb(getApplicationContext()).getUserDao();
    }

    //changes activity to "activity_registrieren"
    public void goToRegistrieren (View view){
        Intent intent = new Intent (this, RegistrierenActivity.class);
        startActivity(intent);
    }

    //changes activity to "activity_logedin"
    public void goToLogedin (View view){
        Intent intent = new Intent (this, LoggedinActivity.class);
        startActivity(intent);
    }
}
