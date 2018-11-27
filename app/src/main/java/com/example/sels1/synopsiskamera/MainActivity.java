package com.example.sels1.synopsiskamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToPicture(View view){
        Intent intent = new Intent(this, PictureActivity.class );
        startActivity(intent);
    }
    public void GoToVideo(View view){
        Intent intent = new Intent(this, VideoActivity.class );
        startActivity(intent);
    }

}
