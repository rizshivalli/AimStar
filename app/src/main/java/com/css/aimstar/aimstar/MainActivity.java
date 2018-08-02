package com.css.aimstar.aimstar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.css.aimstar.aimstar.adapter.TextTabsAdapter;
import com.css.aimstar.aimstar.fragments.ChatFragment;
import com.css.aimstar.aimstar.fragments.DashboardFragment;
import com.css.aimstar.aimstar.fragments.HomeFragment;
import com.css.aimstar.aimstar.fragments.ProfileFragment;
import com.css.aimstar.aimstar.tabsfragment.StoryFragment;
import com.css.aimstar.aimstar.tabsfragment.TweetFragment;
import com.css.aimstar.aimstar.utils.BottomNavigationHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextTabsAdapter adapter;
    private Toolbar toolbar;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
        clicklisteners();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_panel, new HomeFragment()).addToBackStack(null)
                .commit();



    }

    private void initialise() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }






    private void clicklisteners() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = null;
            try {
                intent = new Intent(this, Class.forName("com.example.dell.aimlchatbot.MainActivity"));
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else if (id == R.id.nav_slideshow) {
            Intent intent1 = new Intent(this,ProfileActivity.class );
            startActivity(intent1);



        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_panel, new HomeFragment()).addToBackStack(null)
                            .commit();
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("Dashboard");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_panel, new DashboardFragment()).addToBackStack(null)
                            .commit();
                   // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle("Conversation");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_panel, new ChatFragment()).addToBackStack(null)
                            .commit();
                  //  mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile:
                   // toolbar.setTitle("Profile");
                    // intent.setClassName("com.example.dell.aimlchatbot", "MainActivity");
Intent intent2 = new Intent(MainActivity.this,ProfileActivity.class);
startActivity(intent2);
                   /* getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_panel, new ProfileFragment()).addToBackStack(null)
                            .commit();*/
                    //  mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
}
