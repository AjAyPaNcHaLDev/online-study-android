package com.dde.online;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import com.dde.online.Fragment.Analytics;
import com.dde.online.Fragment.Comments;
import com.dde.online.Fragment.Curriculum;
import com.dde.online.Fragment.Download;
import com.dde.online.Fragment.FundamentalTest;
import com.dde.online.Fragment.GoogleMeet;
import com.dde.online.Fragment.Instructor;
import com.dde.online.Fragment.MockTest;
import com.dde.online.Fragment.Module;
import com.dde.online.Fragment.Overview;
import com.dde.online.Fragment.Reviews;
import com.dde.online.Fragment.TrialClasses;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.tabs.TabLayout;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;

public class PlayerMain extends AppCompatActivity {

    PlayerView mainPlayer;
    SimpleExoPlayer player;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_main);
        mainPlayer=findViewById(R.id.mainPlayer);
        player = new SimpleExoPlayer.Builder(this).build();
        mainPlayer.setPlayer(player);
        MediaItem mediaItem=MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        MediaItem mediaItem2=MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4");
        player.addMediaItem(mediaItem);
        player.addMediaItem(mediaItem2);
        player.prepare();

        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Curriculum()).commit();//   

        tabLayout=findViewById(R.id.tab_layout);
        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:

                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Curriculum()).commit();//   

                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Download()).commit();//   


                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new FundamentalTest()).commit();//   


                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Comments()).commit();//


                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new GoogleMeet()).commit();//   


                        break;
                    case 5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new MockTest()).commit();//   


                        break;

                    case 6:
                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Analytics()).commit();//   


                        break;


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(player.isPlaying()){
            player.pause();
        }

    }


}