package com.sixgroup.appsinaamin.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.AppDatabase;
import com.sixgroup.appsinaamin.persistence.UserDao;
import com.sixgroup.appsinaamin.user.User;

//Class that starts, if the User is logged in
//Welcome Screen with name
public class LoggedinActivity extends AppCompatActivity {


    //creates activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        //creating TextViews for the first- and lastname
        TextView textViewVornameLoggedin = findViewById(R.id.textViewVornamelogedin);
        TextView textViewNachnameLoggedin = findViewById(R.id.textViewNachnamelogedin);
        UserDao userDao;

        //set Dao
        userDao = AppDatabase.getAppDb(this.getApplicationContext()).getUserDao();

        //get the User that logged in
        Intent intent = getIntent();
        String email = intent.getStringExtra(getString(R.string.editTextEmail));
        User user = userDao.getByEmail(email);

        //set TextViews to the name of the logged in User
        textViewVornameLoggedin.setText(user.getVorname());
        textViewNachnameLoggedin.setText(user.getNachname());
    }

    //changes activity to "activity_main"
    public void goToLogin (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}