package com.sixgroup.appsinaamin.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.sixgroup.appsinaamin.R;
import com.sixgroup.appsinaamin.persistence.AppDatabase;
import com.sixgroup.appsinaamin.persistence.UserDao;
import com.sixgroup.appsinaamin.user.User;

import java.io.ByteArrayOutputStream;

//Class that opens the activity in which you can upload photos
public class FotohochladenActivity extends AppCompatActivity {

    // Define the pic id
    private static final int pic_id = 123;

    //the user Dao
    private UserDao userDao;

    // Define the button and imageview type variable
    Button camera_open_id;
    ImageView click_image_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotohochladen);

        //set Dao
        userDao = AppDatabase.getAppDb(this.getApplicationContext()).getUserDao();

        // By ID we can get each component
        // which id is assigned in XML file
        // get Buttons and imageview.
        click_image_id = findViewById(R.id.profilePic);


        // Camera_open button is for open the camera
        // and add the setOnClickListener in this button
        click_image_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create the camera_intent ACTION_IMAGE_CAPTURE
                // it will open the camera for capture the image
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // Start the activity with camera_intent,
                // and request pic id
                startActivityForResult(camera_intent, pic_id);
            }
        });
    }

    public void goToLoggedin (View view){
        Intent intent = new Intent (this, LoggedinActivity.class);
        saveToDatabase(intent);
        startActivity(intent);
    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            // BitMap is data structure of image file
            // which stor the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }
    }

    //saves data into database with no image
    public void saveToDatabase(Intent intent) {

        String firstName = getString(R.string.vorname);
        String lastName = getString(R.string.nachname);
        String email = getString(R.string.editTextEmail);
        String password = getString(R.string.editTextPassword);

        ImageView image = findViewById(R.id.profilePic);
        Bitmap imageBitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] img = bos.toByteArray();
        intent.putExtra(getString(R.string.editTextEmail), email);

        userDao.insertUser(firstName, lastName, email, password, img);
    }
}