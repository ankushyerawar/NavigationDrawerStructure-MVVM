package com.ankushyerwar.blankndstructure.ui.activities;

import android.os.Bundle;

import com.ankushyerwar.blankndstructure.ui.fragments.HomeFragment;
import com.ankushyerwar.blankndstructure.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mMainDrawerLayout;

    @BindView(R.id.toolbar)
    Toolbar mMainToolbar;

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @BindView(R.id.nav_view)
    public NavigationView mNavigationView;

    private AppBarConfiguration mAppBarConfiguration;
    public View mHeaderView;
    private Fragment mNavHostFragment;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    public void onBackPressed() {
        final Fragment currentFragment = mNavHostFragment.getChildFragmentManager()
                .getFragments().get(0);
        if (mMainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mMainDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (currentFragment instanceof HomeFragment) {
            finish();
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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

    private void initViews() {
        ButterKnife.bind(this);
        setSupportActionBar(mMainToolbar);

        mNavHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.galleryFragment, R.id.slideShowFragment)
                .setDrawerLayout(mMainDrawerLayout)
                .build();

        NavigationUI.setupWithNavController(mNavigationView, mNavController);
        NavigationUI.setupWithNavController(mMainToolbar,mNavController,mAppBarConfiguration);

        /* When Set like this it works fine but when drawer items are selected the navigation up
         * button is enabled and when clicked on that the drawer opens and you are not redirected
         * to min fragment*/
        //NavigationUI.setupActionBarWithNavController(this,mNavController,mMainDrawerLayout);

        /* When Set like this you will get proper functionality but if you want to hide Hamburger
         * icon you cannot do that and also drawer is not locked by default when navigation up
         * button is visible*/
        //NavigationUI.setupWithNavController(mMainToolbar,mNavController,mAppBarConfiguration);
        //NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);

        /* When Set like this you will see navigation up button (Back Button) when you select
         * Navigation Drawer Items instead of Hamburger icon*/
        //NavigationUI.setupWithNavController(mMainToolbar, mNavController, mMainDrawerLayout);

        /* When Set like this you will not get Navigation Drawer Hamburger Icon but still you will
         * be accessible to drawer */
        //NavigationUI.setupWithNavController(mMainToolbar,mNavController);
        //NavigationUI.setupActionBarWithNavController(this,mNavController);

        mHeaderView = mNavigationView.getHeaderView(0);

        mFab.setOnClickListener(view ->

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

        );
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, mAppBarConfiguration);
    }

    //to lock drawer when not needed
    public void setDrawerLocked(boolean enabled) {
        if (enabled) {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }
}
