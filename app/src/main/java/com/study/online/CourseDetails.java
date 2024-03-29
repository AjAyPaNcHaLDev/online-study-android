package com.study.online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.study.online.Fragment.Curriculum;
import com.study.online.Fragment.Instructor;
import com.study.online.Fragment.Overview;
import com.study.online.Fragment.Reviews;
import com.study.online.Fragment.TrialClasses;
import com.google.android.material.tabs.TabLayout;

public class CourseDetails extends AppCompatActivity {
//    private TextView bt_toggle;
//    private View lyt_more;
private View parent_view;
//    private View bottom_sheet;
//    private BottomSheetBehavior mBehavior;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

//        lyt_more = findViewById(R.id.lyt_more);
//        lyt_more.setVisibility(View.GONE);

//        bt_toggle = findViewById(R.id.bt_toggle);
//        bt_toggle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toggleSection();
//            }
//        });
//        mySheet();
        getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Overview()).commit();//    this is the home fragment by default

        tabLayout=findViewById(R.id.tab_layout);
       tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {

               switch (tab.getPosition()){
                   case 0:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Overview()).commit();//    this is the home fragment by default
                       break;
                   case 1:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new TrialClasses()).commit();//    this is the home fragment by default


                       break;
                   case 2:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Curriculum()).commit();//    this is the home fragment by default


                       break;

                   case 3:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Instructor()).commit();//    this is the home fragment by default


                       break;

                   case 4:
                       getSupportFragmentManager().beginTransaction().replace(R.id.tab_container,new Reviews()).commit();//    this is the home fragment by default

//                       break;
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

//
        LinearLayout continueCourse=findViewById(R.id.continueCourse);
        continueCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CourseDetails.this,PlayerMain.class));
            }
        });





    }
//    private void toggleSection( ) {
////        boolean show = Tools.toggleArrow(view);
//        if (lyt_more.getVisibility()==View.VISIBLE) {
//            bt_toggle.setText("see more");
//            Toast.makeText(CourseDetails.this," "+lyt_more.getHeight(),Toast.LENGTH_LONG).show();
//            ViewAnimation.collapse(lyt_more);
//        } else {
//            ViewAnimation.expand(lyt_more, new ViewAnimation.AnimListener() {
//                @Override
//                public void onFinish() {
//                    bt_toggle.setText("see less");
//                    Toast.makeText(CourseDetails.this," "+lyt_more.getHeight(),Toast.LENGTH_LONG).show();
//
//                }
//            });
//        }
//    }

//   public  void  mySheet(){
//        bottom_sheet = findViewById(R.id.bottom_sheet);
//
//        mBehavior = BottomSheetBehavior.from(bottom_sheet);
//mBehavior.setPeekHeight(300);
//        mBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//                    ViewAnimation.rotate(findViewById(R.id.bt_expand), true);
//                } else {
//                    ViewAnimation.rotate(findViewById(R.id.bt_expand), false);
//                    mBehavior.setPeekHeight(130);
//
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });
//       (findViewById(R.id.bt_expand)).setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//                   mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                   ViewAnimation.rotate(v, true);
//               } else {
//                   mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                   ViewAnimation.rotate(v, false);
//               }
//           }
//       });
//    }


}