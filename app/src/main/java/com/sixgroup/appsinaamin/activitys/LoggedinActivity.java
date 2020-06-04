package com.sixgroup.appsinaamin.activitys;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.AppDatabase;
import com.sixgroup.appsinaamin.persistence.UserDao;
import com.sixgroup.appsinaamin.user.User;

public class LoggedinActivity extends AppCompatActivity {


    //creates activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        TextView textViewVornameLoggedin = findViewById(R.id.textViewVornamelogedin);
        TextView textViewNachnameLoggedin = findViewById(R.id.textViewNachnamelogedin);
        UserDao userDao;

        //set Dao
        userDao = AppDatabase.getAppDb(this.getApplicationContext()).getUserDao();

        String email = getString(R.string.editTextEmail);
        User user = userDao.getByEmail(email);

        textViewVornameLoggedin.setText(user.getVorname());
        textViewNachnameLoggedin.setText(user.getNachname());
    }



}