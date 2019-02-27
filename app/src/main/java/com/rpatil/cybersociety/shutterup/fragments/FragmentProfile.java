package com.rpatil.cybersociety.shutterup.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpatil.cybersociety.shutterup.R;

public class FragmentProfile extends Fragment {
    private static final String TAG = "FragmentProfile";

    private String title;
    private int page;

    public FragmentProfile() {
        // Required empty public constructor
    }

    public static FragmentProfile newInstance(int page, String title) {
        FragmentProfile fragmentProfile = new FragmentProfile();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        fragmentProfile.setArguments(args);
        return fragmentProfile;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }
}
