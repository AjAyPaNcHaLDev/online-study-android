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

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;


public class TrialClasses extends Fragment {
PlayerView video1,    video2,            video3;
boolean play_when_ready=true;
long play_back_position=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_trial_classes, container, false);
video1=view.findViewById(R.id.video1);
video2=view.findViewById(R.id.video2);
video3=view.findViewById(R.id.video3);
initPlayer("https://www.youtube.com/watch?v=8MLa-Lh8lkU",video1);
initPlayer("https://www.youtube.com/watch?v=8MLa-Lh8lkU",video2);
initPlayer("https://www.youtube.com/watch?v=8MLa-Lh8lkU",video3);
        return view;
    }

    private void initPlayer(String url, PlayerView video) {
        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
video.setPlayer(simpleExoPlayer);
        initYoutubeVideo(url, simpleExoPlayer);

    }

   @SuppressLint("StaticFieldLeak")
   public void  initYoutubeVideo(String url,SimpleExoPlayer simpleExoPlayer){
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
    simpleExoPlayer.setMediaSource(new MergingMediaSource(true,
            videoSource,
            audioSource),
            true);
    simpleExoPlayer.prepare();
    simpleExoPlayer.setPlayWhenReady(play_when_ready);
    simpleExoPlayer.seekTo(0,0);
}
            }
        }.extract(url,false ,true);

    }
}