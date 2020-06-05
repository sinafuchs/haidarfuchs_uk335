package com.sixgroup.appsinaamin.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.AppDatabase;
import com.sixgroup.appsinaamin.persistence.UserDao;
import com.sixgroup.appsinaamin.user.User;

//Class that opens first activity, which is the Login
public class MainActivity extends AppCompatActivity {

    //Database connection
    public static UserDao userDao;

    //creates activity and shows the Login to the User
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = AppDatabase.getAppDb(this.getApplicationContext()).getUserDao();
    }

    //changes activity to "activity_registrieren"
    public void goToRegistrieren (View view){
        Intent intent = new Intent (this, RegistrierenActivity.class);
        startActivity(intent);
    }

    //changes activity to "activity_loggedin"
    public void goToLoggedin(){
        Intent intent = new Intent (this, LoggedinActivity.class);
        startActivity(intent);
    }

    //Logs the User in
    public void login(View view) {
        EditText emailEdit = findViewById(R.id.editTextEmail);
        EditText passwordEdit = findViewById(R.id.editTextPasswort);

        //looks if the entered password and email is the same as the one in the database
        String password = passwordEdit.getText().toString();
        User user = userDao.getByEmail(emailEdit.getText().toString());
        if(user != null) {
            if (("" + password.hashCode()).equals(user.getPasswort())) {
                goToLoggedin();
            }
        }
    }
}
