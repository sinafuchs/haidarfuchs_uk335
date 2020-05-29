package com.sixgroup.appsinaamin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);

=======
        setContentView(R.layout.activity_fotohochladen);
>>>>>>> 95dbfff8f826dc20ba5c47fedf1975401f6acb94
    }

    public void goToRegistrieren (View view){
        Intent intent = new Intent (this, RegistrierenActivity.class);
        startActivity(intent);
    }
}
