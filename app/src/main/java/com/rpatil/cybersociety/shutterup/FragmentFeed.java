package com.rpatil.cybersociety.shutterup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentFeed extends Fragment {
    private static final String TAG = "FragmentFeed";

    private String title;
    private int page;

    public FragmentFeed() {
        // Required empty public constructor
    }

    public static FragmentFeed newInstance(int page, String title) {
        FragmentFeed fragmentFeed = new FragmentFeed();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        fragmentFeed.setArguments(args);
        return fragmentFeed;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_feed, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }
}
