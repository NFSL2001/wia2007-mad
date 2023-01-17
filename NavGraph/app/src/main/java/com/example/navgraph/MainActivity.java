package com.example.navgraph;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle; //pull it out to sync state
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // replace toolbar on top
        Toolbar toolbar = (Toolbar) findViewById(R.id.TBMainAct); //find the toolbar on top
        setSupportActionBar(toolbar); //make this the toolbar for this activity

        // add drawer listener
        drawerLayout = findViewById(R.id.DLMain); //get drawer
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        ); // toggle drawer listener
        drawerLayout.addDrawerListener(toggle); //adding drawer listener to
        //toggle.syncState();

        // bind navhostfragment (in xml) to navcontroller
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.NHFMain);
        NavController navController = host.getNavController(); //get controller to move fragment around nav map

        // bind toolbar with navController
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // bind bottom nav menu with navController
        setupBottomNavMenu(navController);

        // bind drawer with navController
        setupNavMenu(navController);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    // add ~~bottom~~ side menu options to toolbar (as overflow)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }

    // add actions to options in overflow
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try{
            //navigation change to the ID of the option clicked (name in nav map)
            Navigation.findNavController(this, R.id.NHFMain).navigate(item.getItemId());
            return true;
        } catch (Exception ex) {
            return  super.onOptionsItemSelected(item);
        }
    }

    // allow up action to go back
    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.NHFMain).navigateUp();
    }

    // bind bottom navigation menu with actions
    private void setupBottomNavMenu(NavController navController){
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view); //find the bottom menu
        NavigationUI.setupWithNavController(bottomNav, navController, false); //bind actions with navcontroller
    }

    //bind nav drawer with actions
    private void setupNavMenu(NavController navController) {
        NavigationView sideNav = findViewById(R.id.sideNav);
        NavigationUI.setupWithNavController(sideNav, navController, false);
    }
}
