package com.study.online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.study.online.Fragment.Explore;
import com.study.online.Fragment.Home;
import com.study.online.Fragment.MyProfile;
import com.study.online.utils.Tools;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private ActionBar actionBar;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Home()).commit();//    this is the home fragment by default
        initComponent();
        initToolbar();
        initNavigationMenu();
    }



    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
//        actionBar.setLogo(R.drawable.online_study_logo_remove_bg);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(" ");
        Tools.setSystemBarColor(this, R.color.grey_10);
        Tools.setSystemBarLight(this);
    }




    private void initNavigationMenu() {
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        // open drawer at start
        drawer.openDrawer(GravityCompat.START);
   drawer.close();

    }
    private void initComponent() {


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Home()).commit();//    this is the home fragment by default

                        return true;
                    case R.id.myProfile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new MyProfile()).commit();//    this is the home fragment by default
                        return true;
                    case R.id.explore:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default
                       return true;
                       case R.id.myBatches:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default
                       return true;
                }
                return false;
            }
        });
 }

    @Override
    public void onBackPressed() {

    }

    public void onNavClick(View view) {
switch (view.getId()){
    case R.id.nav_home:
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Home()).commit();//    this is the home fragment by default
        drawer.close();
        break;
    case R.id.nav_Profile:
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new MyProfile()).commit();//    this is the home fragment by default
        drawer.close();
        break;
    case R.id.nav_betches:
        //  getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default
        drawer.close();
        break;
    case R.id.nav_History:
        //  getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default
        Toast.makeText(MainActivity.this,"History",Toast.LENGTH_SHORT).show();
        drawer.close();
        break;
    case R.id.nav_inviteEarn:
        //  getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default
        Toast.makeText(MainActivity.this,"Invite And Earn",Toast.LENGTH_SHORT).show();
        drawer.close();
        break;
    case R.id.navLogout:
        //  getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Explore()).commit();//    this is the home fragment by default
Toast.makeText(MainActivity.this,"Logout successfully",Toast.LENGTH_SHORT).show();
        drawer.close();
        break;

}
    }
}