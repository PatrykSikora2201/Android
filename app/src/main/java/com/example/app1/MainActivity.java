package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Button toggleButton;
    boolean hasCameraFlash = false;
    boolean flashOn = false;


    private void flashLightOn(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            Toast.makeText(MainActivity.this, "Latarka jest włączona", Toast.LENGTH_SHORT).show();
        }
        catch(CameraAccessException e){
            Log.e("Camera Problem", "Nie można uruchomić Latarki");
        }
    }

    private void flashLightOff(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            Toast.makeText(MainActivity.this, "Latarka jest wyłączona", Toast.LENGTH_SHORT).show();
        }
        catch(CameraAccessException e){
            Log.e("Camera Problem", "Nie można uruchomić Latarki");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.power_off);

        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        toggleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(hasCameraFlash){
                    if(flashOn){
                        flashOn = false;
                        flashLightOff();
                    }
                    else{
                        flashOn = true;
                        flashLightOn();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Laterka nie jest dostępna", Toast.LENGTH_SHORT).show();
                }
            }
        });



        Button localView_btn = (Button) findViewById(R.id.local_view);
        Button YTView_btn = (Button) findViewById(R.id.yt_view);



        localView_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, LocalViewerActivity.class);
            startActivity(intent);


        });

        YTView_btn.setOnClickListener(v -> {

            Intent intent = new Intent(this, YtActivity.class);
            startActivity(intent);

        });

    }

}

