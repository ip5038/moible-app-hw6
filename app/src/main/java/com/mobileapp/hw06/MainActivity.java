package com.mobileapp.hw06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.BottomNavigationViewKt;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/***********************************************
 Author: Ishan Patel
 Date: Nov 5 2022
 Purpose: Crate Lights Out game
 What Learned: How to create multiple screen app and pass data between each screen.
 Sources of Help: Stackoverflow and previous projects
 Time Spent: 6 hours
 ***********************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppBarConfiguration.Builder builder = new
                AppBarConfiguration.Builder(navController.getGraph());
        AppBarConfiguration appBarConfiguration = builder.build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController =
                Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item,
                navController) || super.onOptionsItemSelected(item);
    }
}

/*
Mobile App Development I -- COMP.4630 Honor Statement
The practice of good ethical behavior is essential for
maintaining good order in the classroom, providing an enriching
learning experience for students, and training as a practicing
computing professional upon graduation. This practice is
manifested in the University's Academic Integrity policy.
Students are expected to strictly avoid academic dishonesty and
adhere to the Academic Integrity policy as outlined in the course
catalog. Violations will be dealt with as outlined therein. All
programming assignments in this class are to be done by the
student alone unless otherwise specified. No outside help is
permitted except the instructor and approved tutors.
I certify that the work submitted with this assignment is mine
and was generated in a manner consistent with this document, the
course academic policy on the course website on Blackboard, and
the UMass Lowell academic code.
Date: Nov 5 2022
Name: Ishan Patel
*/