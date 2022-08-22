package com.dde.online;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dde.online.Fragment.Home;
import com.dde.online.Fragment.Overview;
import com.dde.online.Fragment.TrialClasses;
import com.dde.online.utils.Tools;
import com.dde.online.utils.ViewAnimation;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PlayerMain extends AppCompatActivity {
    private TextView bt_toggle;
    private View lyt_more;
    TabItem overView,trialClasses;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_main);

        lyt_more = findViewById(R.id.lyt_more);
//        lyt_more.setVisibility(View.GONE);
        bt_toggle = findViewById(R.id.bt_toggle);
        bt_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSection();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Overview()).commit();//    this is the home fragment by default

        tabLayout=findViewById(R.id.tab_layout);
       tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {

               switch (tab.getPosition()){
                   case 0:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Overview()).commit();//    this is the home fragment by default

                       Toast.makeText(PlayerMain.this,"overview selected",Toast.LENGTH_SHORT).show();
                       break;
                   case 1:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new TrialClasses()).commit();//    this is the home fragment by default

                       Toast.makeText(PlayerMain.this,"trial classes selected",Toast.LENGTH_SHORT).show();
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
    private void toggleSection( ) {
//        boolean show = Tools.toggleArrow(view);
        if (lyt_more.getVisibility()==View.VISIBLE) {
            bt_toggle.setText("see more");
            ViewAnimation.collapse(lyt_more);
        } else {
            ViewAnimation.expand(lyt_more, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    bt_toggle.setText("see less");

                }
            });
        }
    }
}