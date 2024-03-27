package com.example.mobilprestamos.modulos.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.mobilprestamos.R;
import com.example.mobilprestamos.modulos.home.fragment.HomeFragment;
import com.example.mobilprestamos.modulos.login.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private Fragment currentFragment;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      /*  FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
         drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void goToMainFragment()
    {
        if (currentFragment instanceof HomeFragment) {

        } else {
            goToHome();
            setTitle(title);
        }
    }

    private void goToHome()
    {
        title = getText(R.string.menu_home).toString();
        currentFragment = HomeFragment.newInstance();
        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.contenedor,currentFragment, currentFragment.getClass().getCanonicalName());
        FT.addToBackStack(null);
        FT.commit();
        setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        selectItem(item);
        drawer.closeDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setupNavigationDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /*selectItem(item);
                drawer.closeDrawer(GravityCompat.START);*/
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        goToHome();

                        break;
                    case R.id.menuprincipal_clientes:

                        break;
                    case R.id.menuprincipal_prestamos:

                        break;
                    case R.id.menuprincipal_cobros:

                        break;

                }
                return false;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItem(item);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void selectItem(MenuItem item)
    {
        try {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    goToHome();

                    break;
                case R.id.menuprincipal_clientes:

                    break;
                case R.id.menuprincipal_prestamos:

                    break;
                case R.id.menuprincipal_cobros:

                    break;

            }
           // setTitle(title);
            //   loadCurrentFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    private void goToHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
}