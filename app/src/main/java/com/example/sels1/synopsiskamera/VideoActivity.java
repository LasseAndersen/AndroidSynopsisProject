package com.example.sels1.synopsiskamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.net.URI;

public class VideoActivity extends AppCompatActivity {


    private final int VIDEO_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }


    public void CaptureVideo(View view){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File videoFile = GetFilePath();
        Uri uri = Uri.fromFile(videoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, VIDEO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VIDEO_REQUEST_CODE){

            if (resultCode == RESULT_OK){

                Toast.makeText(getApplicationContext(), "Video was recorded", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Video recording failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    public File GetFilePath(){
        File folder = new File("sdcard/video_app");
        if (!folder.exists()){
            folder.mkdir();
        }
        File video_file = new File(folder, "sample_name.mp4");
        return video_file;
    }
}
