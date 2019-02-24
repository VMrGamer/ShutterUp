package com.rpatil.cybersociety.shutterup;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.rpatil.cybersociety.shutterup.fragments.FragmentCategory;
import com.rpatil.cybersociety.shutterup.fragments.FragmentProfile;
import com.rpatil.cybersociety.shutterup.fragments.feed.FragmentFeed;

public class MainActivity extends AppCompatActivity implements FragmentFeed.OnFragmentInteractionListener{
    private static final String TAG = "MainActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    fragment = FragmentFeed.newInstance("3","Feed");
                    break;
                case R.id.navigation_category:
                    fragment = FragmentCategory.newInstance(3,"Category");
                    break;
                case R.id.navigation_profile:
                    fragment = FragmentProfile.newInstance(3,"Profile");
                    break;
            }
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: YO");

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_feed);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
