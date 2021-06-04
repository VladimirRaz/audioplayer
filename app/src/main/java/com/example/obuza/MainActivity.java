package com.example.obuza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;


import com.example.obuza.databinding.ActivityMainCBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainCBinding binding = ActivityMainCBinding.inflate(getLayoutInflater());
        binding.setActivityMain(this);
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        binding.sectionsControl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("onTabSelected", "" + tab.getPosition());
                switch (tab.getPosition()) {
                    case 0: navController.navigate(R.id.fragmentAllMusic); break;
                    case 1: navController.navigate(R.id.fragmentAlbums); break;
                    case 2: navController.navigate(R.id.fragmentFavorite); break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


//
//    public void changeSection(int sectionId) {
//        switch (sectionId) {
//            case 0: navController.navigate(R.id.fragmentAllMusic); break;
//            case 1: navController.navigate(R.id.fragmentFavorite); break;
//
//        }
//    }
}