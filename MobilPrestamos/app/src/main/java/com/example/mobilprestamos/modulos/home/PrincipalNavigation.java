package com.example.mobilprestamos.modulos.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.mobilprestamos.R;
import com.google.android.material.navigation.NavigationView;

public class PrincipalNavigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @SuppressLint("StaticFieldLeak")
    static PrincipalNavigation instance = null;

    public static PrincipalNavigation getInstance()
    {
        return instance;
    }
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private CharSequence title;
    private Toolbar toolbar;
    private Fragment currentFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_navigation);
        instance = this;
       // loadActionBar();
        //loadNavigationView();
        //initDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

   /* private void initDrawer()
    {
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }
            }

            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(DataSyncEvent syncStatusMessage)
    {
        if(syncStatusMessage != null && syncStatusMessage.getIfRealunchMessagesQuery())
        {
            updateAlertMensajes(false);
        }
    }

    private void loadActionBar()
    {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvToolbarTitle = toolbar.findViewById(R.id.tvToolbarTitle);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    private void loadNavigationView()
    {
        try {
            navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            Menu menu = navigationView.getMenu();


        } catch (Exception e) {
        }
    }


    @Override
    public void onBackPressed()
    {
        if (doubleBackToExitPressedOnce) {
            //finish();
            //super.onBackPressed();
            //return;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment != null) {
                this.doubleBackToExitPressedOnce = true;

                int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();
                if (fragmentCount > 0) {
                  //  goToHome();
                   // loadCurrentFragment();
                } else {
                    if (currentFragment instanceof HomeFragmentNew) {
                       // goToHome();
                      //  loadCurrentFragment();
                    } else {
                        if (getDrawer() != null) {
                            menuToggle();
                        }
                    }
                }
            }
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    doubleBackToExitPressedOnce = false;
                }
            }, 500);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        selectItem(item);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void setTitle(CharSequence title)
    {
        this.title = title;
        setTvToolbarTitle(title.toString());
    }


    public void setTvToolbarTitle(String tvToolbarTitle)
    {
        if (this.tvToolbarTitle != null) {
            this.tvToolbarTitle.setText(tvToolbarTitle);
        }
    }

    private void selectItem(MenuItem item)
    {
        try {
            switch (item.getItemId()) {
                case R.id.menuprincipal_home:

                    break;
                case R.id.menuprincipal_clientes:

                    break;
                case R.id.menuprincipal_prestamos:

                    break;
                case R.id.menuprincipal_cobros:

                    break;

            }
            setTitle(title);
         //   loadCurrentFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}