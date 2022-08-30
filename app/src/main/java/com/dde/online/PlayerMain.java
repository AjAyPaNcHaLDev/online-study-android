package com.dde.online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;

import com.dde.online.Fragment.Analytics;
import com.dde.online.Fragment.Comments;
import com.dde.online.Fragment.Curriculum;
import com.dde.online.Fragment.Download;
import com.dde.online.Fragment.FundamentalTest;
import com.dde.online.Fragment.GoogleMeet;
import com.dde.online.Fragment.MockTest;
import com.dde.online.utils.Tools;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.transition.MaterialContainerTransform;

public class PlayerMain extends AppCompatActivity {

    PlayerView mainPlayer;
    SimpleExoPlayer player;
    TabLayout tabLayout;
    private ExtendedFloatingActionButton bt_support;
    private View endView;
    private FrameLayout root;
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
        initChat();
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
//                    case 5:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new MockTest()).commit();//
//                        break;
                    case 5://6:
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




    public void initChat() {
        root = findViewById(R.id.root_view);
        bt_support = findViewById(R.id.bt_support);
        endView = findViewById(R.id.bottom_sheet);
        ViewCompat.setTransitionName(bt_support, String.valueOf(bt_support.getId()));
        bt_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEndView(v);
            }
        });

        (findViewById(R.id.bt_expand)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        new Handler(this.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                showEndView(bt_support);
            }
        }, 600);
    }

    private void showEndView(View startView) {
        // Construct a container transform transition between two views.
        MaterialContainerTransform transition = buildContainerTransform(true);
        transition.setStartView(startView);
        transition.setEndView(endView);
        // Add a single target to stop the container transform from running on both the start and end view.
        transition.addTarget(endView);
        transition.addListener(new TransitionListenerAdapter() {
            @Override
            public void onTransitionEnd(@NonNull Transition transition) {
                super.onTransitionEnd(transition);

            }
        });

        // Trigger the container transform transition.
        startView.setVisibility(View.INVISIBLE);
        endView.setVisibility(View.VISIBLE);
    }

    private void showStartView(View endView) {
        View startView = bt_support;
        // Construct a container transform transition between two views.
        MaterialContainerTransform transition = buildContainerTransform(false);
        transition.setStartView(endView);
        transition.setEndView(startView);

        // Add a single target to stop the container transform from running on both the start
        transition.addTarget(startView);

        // Trigger the container transform transition.
        TransitionManager.beginDelayedTransition(root, transition);
        startView.setVisibility(View.VISIBLE);
        endView.setVisibility(View.INVISIBLE);

        Tools.setSystemBarColor(this, R.color.grey_3);
        Tools.setSystemBarLight(this);


    }

    @NonNull
    private MaterialContainerTransform buildContainerTransform(boolean entering) {
        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setTransitionDirection(entering ? MaterialContainerTransform.TRANSITION_DIRECTION_ENTER : MaterialContainerTransform.TRANSITION_DIRECTION_RETURN);
        transform.setDrawingViewId(root.getId());
        transform.setDuration(500);
        return transform;
    }

    @Override
    public void onBackPressed() {
        if (endView != null && endView.getVisibility() == View.VISIBLE) {
            showStartView(endView);
        } else {
            super.onBackPressed();
        }
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