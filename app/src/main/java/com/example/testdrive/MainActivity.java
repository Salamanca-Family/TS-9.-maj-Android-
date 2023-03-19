package com.example.testdrive;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testdrive.databinding.ActivityMainBinding;
import com.example.testdrive.databinding.FragmentFirstBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.PopupMenu;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private FragmentFirstBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        bind = FragmentFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sideMenu.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.9maj.rs/index.php"));
                startActivity(browserIntent);
            }
        });
        binding.sideMenu.setNavigationItemSelectedListener(this);
        binding.toolbar.setNavigationOnClickListener(this);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.onBackPressed();
            }
        });
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent browserIntent;
        switch(item.getItemId()){
            case R.id.action_settings:
                Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_content_main).navigate(R.id.OSkoli);
                binding.drawerLayout.closeDrawer(Gravity.RIGHT);
                break;
            case R.id.novine:
                browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://tehno6.wordpress.com"));
                startActivity(browserIntent);
                break;
            case R.id.takmicenja:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.9maj.rs/index.php/novosti/takmicenja"));
                startActivity(browserIntent);
                break;
            case R.id.radovi_ucenika:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.9maj.rs/index.php/novosti/radovi-ucenika"));
                startActivity(browserIntent);
                break;

            case R.id.aktivnosti_i_projekti:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.9maj.rs/index.php/novosti/projekti"));
                startActivity(browserIntent);
                break;
            case R.id.raspored_casova:
                browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://9maj.rs/images/docs/raspored/2209/odeljenja_8sep.pdf"));
                startActivity(browserIntent);
            default:
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed(){
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        if(binding.drawerLayout.isDrawerOpen((Gravity.RIGHT))){
            binding.drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            binding.drawerLayout.openDrawer(Gravity.RIGHT);
        }
    }
}