package com.finalyear.mobcoursesapp.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.finalyear.mobcoursesapp.Authentication.Signin;
import com.finalyear.mobcoursesapp.Utils.Session;
import com.finalyear.mobcoursesapp.ui.fragments.CatalogFragment;
import com.finalyear.mobcoursesapp.ui.fragments.DashboardFragment;
import com.finalyear.mobcoursesapp.ui.fragments.HelpFragment;
import com.finalyear.mobcoursesapp.ui.fragments.InfoFragment;
import com.finalyear.mobcoursesapp.ui.fragments.MyCoursesFragment;
import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.ui.fragments.SearchFragment;
import com.finalyear.mobcoursesapp.ui.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.view.MenuItem;
import android.widget.Toast;

public class BottomNav extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private ActionBarDrawerToggle toggle;

    private Session session;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnav);


        session = new Session(this);
        if (!session.loggedIn()){
            logout();
        }


//      App navigation drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.container);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //Menu icon change
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);


        //make fragment same after rotating
        if (savedInstanceState == null) {
            loadFragment(new CatalogFragment());
        }


//      Bottom View Menu
        BottomNavigationView navView = findViewById(R.id.nav_view_bottom);
        navView.setOnNavigationItemSelectedListener(this);


    }

    private void logout() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(BottomNav.this, Signin.class));
        Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Sign In to continue", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private boolean loadFragment(Fragment fragment) {

        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;


        switch (menuItem.getItemId()) {

            case R.id.navigation_catalogue:
                fragment = new CatalogFragment();
                break;

            case R.id.navigation_search:
                fragment = new SearchFragment();
                break;

            case R.id.navigation_mycourses:
                fragment = new MyCoursesFragment();
                break;

            case R.id.navigation_info:
                fragment = new InfoFragment();
                break;

            case R.id.nav_dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.nav_help:
                fragment = new HelpFragment();
                break;

            case R.id.action_settings:
                fragment = new SettingsFragment();
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_logout:
                logout();
                break;

        }


        drawer.closeDrawer(GravityCompat.START);

        return loadFragment(fragment);

    }
}
