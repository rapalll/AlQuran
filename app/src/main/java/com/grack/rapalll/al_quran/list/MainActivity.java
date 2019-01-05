package com.grack.rapalll.al_quran.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.grack.rapalll.al_quran.JadwalSholatFragment;
import com.grack.rapalll.al_quran.MasjidFragment;
import com.grack.rapalll.al_quran.QuranFragment;
import com.grack.rapalll.al_quran.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Al-Quran");

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_NavView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new QuranFragment());

    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.alquran:
                fragment = new QuranFragment();
                break;
            case R.id.jadwalSholat:
                fragment = new JadwalSholatFragment();
                break;
            case R.id.masque:
                fragment = new MasjidFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
