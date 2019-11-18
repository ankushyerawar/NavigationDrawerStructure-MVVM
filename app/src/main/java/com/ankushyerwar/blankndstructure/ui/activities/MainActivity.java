package com.ankushyerwar.blankndstructure.ui.activities;

import android.app.Activity;
import android.os.Bundle;

import com.ankushyerwar.blankndstructure.ui.fragments.HomeFragment;
import com.ankushyerwar.blankndstructure.R;
import com.ankushyerwar.blankndstructure.ui.interfaces.OnToolbarTitleChanged;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.Menu;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        OnToolbarTitleChanged {

    @BindView(R.id.drawer_layout)
    DrawerLayout mMainDrawerLayout;

    @BindView(R.id.toolbar)
    Toolbar mMainToolbar;

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @BindView(R.id.nav_view)
    public NavigationView mNavigationView;

    public ActionBarDrawerToggle mMainActionBarToggle;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            if (item.isChecked()) {
                mMainDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                //Open fragment from here
                mNavController.navigate(R.id.homeFragment);
            }
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        mMainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initViews() {
        ButterKnife.bind(this);
        setSupportActionBar(mMainToolbar);

        mNavHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        mMainActionBarToggle = new ActionBarDrawerToggle(
                this, mMainDrawerLayout, mMainToolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mMainDrawerLayout.addDrawerListener(mMainActionBarToggle);
        mMainActionBarToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

        mHeaderView = mNavigationView.getHeaderView(0);

        mFab.setOnClickListener(view ->

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

        );

    }

    @Override
    public void onTitleChanged(String title) {
        setToolbarTitle(title);
    }

    private void setToolbarTitle(String title) {
        mMainToolbar.setTitle(title);
    }

    //to lock drawer when not needed
    public  void setDrawerLocked(boolean enabled) {
        if (enabled) {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            mMainActionBarToggle.setDrawerIndicatorEnabled(false);
        } else {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            mMainActionBarToggle.setDrawerIndicatorEnabled(true);
            mMainActionBarToggle.syncState();
        }
    }

    //To set Fragment toolbar back button
    public void setBackButton(Activity activity, boolean enabled) {
        if (enabled) {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            mMainActionBarToggle.setDrawerIndicatorEnabled(false);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            mMainActionBarToggle.setToolbarNavigationClickListener(view -> activity.onBackPressed());
        } else {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
            mMainActionBarToggle.setDrawerIndicatorEnabled(true);
            mMainActionBarToggle.syncState();
        }
    }
}
