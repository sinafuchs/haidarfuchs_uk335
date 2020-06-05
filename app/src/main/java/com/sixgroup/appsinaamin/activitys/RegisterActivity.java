package com.sixgroup.appsinaamin.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextFirstname;
    EditText editTextLastname;
    EditText editTextEmailRegister;

    //on create method starts activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //buttonRegistrieren.setEnabled(false);
    }

    //changes activity to "activity_uploadpicture"
    public void goToUploadPictureActivity(View view){
        Intent intent = new Intent (this, UploadPictureActivity.class);
        getData(intent);
        startActivity(intent);
    }

    //changes activity to "activity_login"
    public void goToLogin (View view){
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }

    public void getData (Intent intent) {
        editTextFirstname = findViewById(R.id.editTextVorname);
        editTextLastname = findViewById(R.id.editTextNachname);
        editTextEmailRegister = findViewById(R.id.editTextEmailRegister);
        EditText editTextPasswordRegister = findViewById(R.id.editTextPasswortRegister);
        EditText editTextPasswordConfirm = findViewById(R.id.editTextPasswortBestaetigen);

        String firstname = editTextFirstname.getText().toString();
        String lastname = editTextLastname.getText().toString();
        String email = editTextEmailRegister.getText().toString();
        String password = editTextPasswordRegister.getText().toString();
        String passwordConfirm = editTextPasswordConfirm.getText().toString();

        if (validateName(firstname) && validateName(lastname)) {

            intent.putExtra(getString(R.string.editTextVorname), firstname);
            intent.putExtra(getString(R.string.editTextNachname), lastname);


        } else{
            editTextFirstname.setError("Der Name darf nur 50 Zeichen lang sein.");
            editTextLastname.setError("Der Name darf nur 50 Zeichen lang sein.");
        }
        if(validateEmail(email)){
            intent.putExtra(getString(R.string.editTextEmail), email);
        }else{
            editTextEmailRegister.setError("Email muss ein korrektes Format enthalten (max.muster@test.com)");
        }
        if(controllPassword(password, passwordConfirm)){
            intent.putExtra(getString(R.string.editTextPassword), "" + password.hashCode());
        }else{
            editTextPasswordRegister.setError("Die beiden Passwörter stimmen nicht überein");
        }
    }


    public boolean validateName(String name){
        if(name.length() > 51){
            return true;
        }else{
            return false;
        }
    }

    public boolean validateEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(email.length() > 100 && email.matches(emailPattern)){
            return true;
        }else{
            return false;
        }
    }


    public boolean controllPassword(String password1, String password2){
        if(password1.equals(password2)){
            return true;
        }else{
            return false;
        }
    }

}
