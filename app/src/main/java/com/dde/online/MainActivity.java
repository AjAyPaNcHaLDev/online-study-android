package com.dde.online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.dde.online.Fragment.Home;
import com.dde.online.Fragment.MyProfile;
import com.dde.online.utils.Tools;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout,new Home()).commit();//    this is the home fragment by default
        initComponent();
        initToolbar();
    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.dde_logo);
        actionBar.setTitle("");
//        actionBar.setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.grey_1000);

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
                    case R.id.navigation_nearby:
                        Toast.makeText(MainActivity.this,"3",Toast.LENGTH_LONG).show();

                        return true;
                }
                return false;
            }
        });




    }

    @Override
    public void onBackPressed() {

    }
}