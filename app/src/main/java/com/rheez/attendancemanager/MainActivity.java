package com.rheez.attendancemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private int mDrawerItem;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            mDrawerItem = 0;
            displayFragment(new HomeFragment());
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(( view -> Toast.makeText(getApplication().getBaseContext(), "Feature not implemented yet", Toast.LENGTH_LONG).show()));

        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(navigationView)) {
            mDrawerLayout.closeDrawer(navigationView);
        }

        else if (mDrawerItem != 0) {
            mDrawerItem = 0;
            displayFragment(new HomeFragment());
        }

        else super.onBackPressed();
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
        Intent intent = null;
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
            intent = new Intent(getApplicationContext(), PreferencesActivity.class);
        else if (id == R.id.action_about)
            intent = new Intent(getApplicationContext(), AboutActivity.class);

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        mDrawerItem = item.getItemId();

        switch (mDrawerItem) {
            case R.id.fragment_timetable:
                displayFragment(new TimetableFragment());
                break;

            case R.id.fragment_go_to_date:
                displayFragment(new GoToDateFragment());
                break;

            case R.id.fragment_detailed_analysis:
                displayFragment(new DetailedAnalysisFragment());
                break;

            case R.id.fragment_overall:
                displayFragment(new OverallFragment());
                break;

            case R.id.fragment_predictor:
                displayFragment(new PredictorFragment());
                break;
        }

        mDrawerLayout.closeDrawer(navigationView);
        return true;
    }

    private void displayFragment(@NonNull Fragment navFragment) {
        supportInvalidateOptionsMenu();
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.content_frame, navFragment)
                .commitNow();
    }
}