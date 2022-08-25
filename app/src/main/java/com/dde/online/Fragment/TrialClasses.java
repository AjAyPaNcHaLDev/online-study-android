package com.dde.online.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dde.online.R;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Util;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;


public class TrialClasses extends Fragment {
PlayerView video1;
boolean play_when_ready=true;
    SimpleExoPlayer player;
long play_back_position=0;
int currentWindow=0;
    @Override
    public void onStart() {
        super.onStart();
        if(Util.SDK_INT>=24){
            initPlayer();
        }
    }

    @Override
    public void onStop() {
        if(Util.SDK_INT>-24){
            releasePlayer();
        }
        super.onStop();

    }

    private void releasePlayer() {
        if(player!=null){
            play_when_ready= player.getPlayWhenReady();
            play_back_position= player.getCurrentPosition();
            currentWindow=player.getCurrentWindowIndex();
            player.release();
            player=null;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(Util.SDK_INT>=24|| player==null){
            initPlayer();
            hideSystemUI();
        }


    }

    private void hideSystemUI() {
        video1.setSystemUiVisibility(
                getView().SYSTEM_UI_FLAG_LOW_PROFILE |
                        getView().SYSTEM_UI_FLAG_FULLSCREEN |
                        getView().SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        getView().SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        getView().SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

    }

    @Override
    public void onPause() {
        if(Util.SDK_INT<24){
            releasePlayer();
        }
        super.onPause();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_trial_classes, container, false);
video1=view.findViewById(R.id.video1);
initPlayer();
        return view;
    }

    private void initPlayer() {
        player = new SimpleExoPlayer.Builder(getContext()).build();
        video1.setPlayer(player);
        initYoutubeVideo("https://www.youtube.com/embed/0zx_eFyHRU0");
    }

   @SuppressLint("StaticFieldLeak")
   public void  initYoutubeVideo(String url){
        new YouTubeExtractor(requireContext()){

            @SuppressLint("StaticFieldLeak")
            @Override
            protected void onExtractionComplete(SparseArray<YtFile> ytFiles, VideoMeta videoMeta) {
if (ytFiles!=null){
    int videoTag=137;//video tag for 1080p
    int audioTag=140; //m4a
    MediaSource  audioSource =new ProgressiveMediaSource.Factory(new DefaultHttpDataSource.Factory())
            .createMediaSource(MediaItem.fromUri(ytFiles.get(audioTag).getUrl()));
    MediaSource  videoSource =new ProgressiveMediaSource.Factory(new DefaultHttpDataSource.Factory())
            .createMediaSource(MediaItem.fromUri(ytFiles.get(videoTag).getUrl()));
    player.setMediaSource(new MergingMediaSource(true,
            videoSource,
            audioSource),
            true);
    player.prepare();
    player.setPlayWhenReady(play_when_ready);
    player.seekTo(0,0);
}
            }
        }.extract(url,false ,true);

    }
}