package com.sixgroup.appsinaamin.activitys;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.UserDao;
import com.sixgroup.appsinaamin.user.User;

public class LoggedinActivity extends AppCompatActivity {


    public TextView textViewVornameLoggedin = findViewById(R.id.textViewVornamelogedin);
    public TextView textViewNachnameLoggedin = findViewById(R.id.textViewNachnamelogedin);
    public UserDao userDao;

    //creates activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        String email = getString(R.string.editTextEmail);
        User user = userDao.getByEmail(email);

        textViewVornameLoggedin.setText(user.getVorname());
        textViewNachnameLoggedin.setText(user.getNachname());
    }



}
