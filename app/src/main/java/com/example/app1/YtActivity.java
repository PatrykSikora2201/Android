package com.example.app1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class YtActivity extends AppCompatActivity{

    YouTubePlayerView yt1;
    YouTubePlayerView yt2;
    YouTubePlayerView yt3;
    YouTubePlayerView yt4;
    YouTubePlayerView yt5;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.yt_viewe);
    }
}
