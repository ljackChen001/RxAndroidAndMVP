package com.cbl.rxandroidandmvp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.cbl.rxandroidandmvp.base.BaseActivity;
import com.cbl.rxandroidandmvp.util.StatusBarUtil;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private RelativeLayout headerBackground;
    private int mStatusBarColor;
    private int mAlpha = StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDrawer();

    }

    private void initView() {
        toolbar = findView(R.id.toolbar);
        drawer = findView(R.id.drawer_layout);
        FloatingActionButton fab =  findView(R.id.fab);
        setSupportActionBar(toolbar);
        if (fab!=null){
            fab.setOnClickListener(v -> showFabDialog());
        }
    }

    private void showFabDialog() {
        new AlertDialog.Builder(MainActivity.this).setTitle("点赞")
                .setMessage("去项目地址给作者个Star，鼓励下作者୧(๑•̀⌄•́๑)૭✧")
                .setPositiveButton("好叻", (dialog, which) -> {
                    Uri uri = Uri.parse(getString(R.string.app_html));   //指定网址
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(),hello.class);
//                    intent.setAction(Intent.ACTION_VIEW);           //指定Action
//                    intent.setData(uri);                            //设置Uri
                    MainActivity.this.startActivity(intent);        //启动Activity
                })
                .show();
    }



    /**
     * 初始化抽屉
     */
    private void initDrawer() {
        NavigationView navigationView= findView(R.id.nav_view);
        if (navigationView!=null){
            navigationView.setNavigationItemSelectedListener(this);
            drawer =findView(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
        }
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

        if (id == R.id.nav_daily_good) {
            // Handle the camera action
        } else if (id == R.id.nav_video) {

        } else if (id == R.id.nav_resource) {

        } else if (id == R.id.nav_app) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_night_mode) {

        }

       drawer = (DrawerLayout) findView(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void setStatusBar() {
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
    }

}
