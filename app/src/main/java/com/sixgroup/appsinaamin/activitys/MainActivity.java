package com.sixgroup.appsinaamin.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.AppDatabase;
import com.sixgroup.appsinaamin.persistence.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       UserDao userDao = AppDatabase.getAppDb(getApplicationContext()).getUserDao();
    }

    public void goToRegistrieren (View view){
        Intent intent = new Intent (this, RegistrierenActivity.class);
        startActivity(intent);
    }

    public void goToLogedin (View view){
        Intent intent = new Intent (this, LoggedinActivity.class);
        startActivity(intent);
    }
}
