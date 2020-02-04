package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shoppingapp.UI.Main.Adapter.TabsAdapter;
import com.example.shoppingapp.UI.Main.CategoryFragment;
import com.example.shoppingapp.UI.Main.HomeFragment;
import com.example.shoppingapp.UI.Main.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_nav) BottomNavigationView bottomNavigationView;
    @BindView(R.id.pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.item_home:

                        viewPager.setCurrentItem(0);
                        bottomNavigationView.getMenu().getItem(0).setChecked(true);

                        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

                        break;
                    case R.id.item_category:

                        viewPager.setCurrentItem(1);
                        bottomNavigationView.getMenu().getItem(1).setChecked(true);
                        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new CategoryFragment()).commit();

                        break;

                    case R.id.item_profile:

                        viewPager.setCurrentItem(2);
                        bottomNavigationView.getMenu().getItem(2).setChecked(true);
                        //getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ProfileFragment()).commit();

                        break;


                }
                return false;
            }
        });

        TabsAdapter tabsAdapter= new TabsAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabsAdapter);
    }
}
