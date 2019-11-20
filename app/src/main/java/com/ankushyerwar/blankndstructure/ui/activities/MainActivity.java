package com.ankushyerwar.blankndstructure.ui.activities;

import android.os.Bundle;

import com.ankushyerwar.blankndstructure.ui.fragments.HomeFragment;
import com.ankushyerwar.blankndstructure.R;
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

    public ActionBarDrawerToggle mMainActionBarToggle;
    private AppBarConfiguration mAppBarConfiguration;
    public View mHeaderView;
    private Fragment mNavHostFragment;
    private NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(mNavigationView, mNavController);
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

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment,R.id.galleryFragment,R.id.slideShowFragment)
                .setDrawerLayout(mMainDrawerLayout)
                .build();

        mHeaderView = mNavigationView.getHeaderView(0);

        mFab.setOnClickListener(view ->

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

        );

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController,mAppBarConfiguration);
    }

    //to lock drawer when not needed
    public  void setDrawerLocked(boolean enabled) {
        if (enabled) {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            mMainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }
}
