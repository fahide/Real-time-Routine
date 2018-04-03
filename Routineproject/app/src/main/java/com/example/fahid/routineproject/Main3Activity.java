package com.example.fahid.routineproject;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void doit(View v){
        Intent intent=new Intent(this,Ftyear.class);
        startActivity(intent);
    }
    public void doitt(View v){
        Intent intent=new Intent(this,Secndyear.class);
        startActivity(intent);
    }public void doittt(View v){
        Intent intent=new Intent(this,Thirdyear.class);
        startActivity(intent);
    }public void doitttt(View v){
        Intent intent=new Intent(this,Fourthyear.class);
        startActivity(intent);
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

        getMenuInflater().inflate(R.menu.main3, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

          if (id == R.id.syllabus) {
            Intent intent=new Intent(this,Showsession.class);
            startActivity(intent);

        } else if (id == R.id.club) {
            Intent browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/1408285125903889?"));
            startActivity(browserintent);

        } else if (id == R.id.admin) {
              Intent browserintent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.000webhost.com/cpanel-login"));
              startActivity(browserintent);


        } else if (id == R.id.association) {
              Intent browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/408338792613622?"));
              startActivity(browserintent);


        } else if (id == R.id.nav_send) {
            Intent browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ru.ac.bd/ice/"));
            startActivity(browserintent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
