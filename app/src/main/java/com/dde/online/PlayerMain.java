package com.dde.online;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dde.online.Fragment.Home;
import com.dde.online.Fragment.Overview;
import com.dde.online.Fragment.TrialClasses;
import com.dde.online.utils.Tools;
import com.dde.online.utils.ViewAnimation;
import com.google.android.material.tabs.TabItem;

public class PlayerMain extends AppCompatActivity {
    private ImageView bt_toggle;
    private View lyt_more;
    TabItem overView,trialClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_main);

        lyt_more = findViewById(R.id.lyt_more);
        lyt_more.setVisibility(View.GONE);
        bt_toggle = findViewById(R.id.bt_toggle);
        bt_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection(bt_toggle);
            }
        });

        overView=findViewById(R.id.overView);
        overView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Overview()).commit();//    this is the home fragment by default
            }
        });
        trialClasses=findViewById(R.id.trialClasses);
        trialClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new TrialClasses()).commit();//    this is the home fragment by default
            }
        });
    }
    private void toggleSection(View view) {
        boolean show = Tools.toggleArrow(view);
        if (show) {
            ViewAnimation.expand(lyt_more, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {

                }
            });
        } else {
            ViewAnimation.collapse(lyt_more);
        }
    }
}