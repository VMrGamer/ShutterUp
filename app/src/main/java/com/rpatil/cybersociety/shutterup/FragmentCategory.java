package com.rpatil.cybersociety.shutterup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCategory extends Fragment {
    private static final String TAG = "FragmentCategory";

    private String title;
    private int page;

    public FragmentCategory() {
        // Required empty public constructor
    }

    public static FragmentCategory newInstance(int page, String title) {
        FragmentCategory fragmentCategory = new FragmentCategory();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        fragmentCategory.setArguments(args);
        return fragmentCategory;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_category, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }
}
