package com.rpatil.cybersociety.shutterup.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.rpatil.cybersociety.shutterup.R;

import java.io.IOException;
import java.util.Objects;

public class FragmentCategory extends Fragment {
    private static final String TAG = "FragmentCategory";

    private static final int READ_REQUEST_CODE = 11;

    private String title;
    private int page;

    public FragmentCategory() {

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
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((Button) view.findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performFileSearch();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                try {
                    Metadata metadata = ImageMetadataReader.readMetadata(Objects.requireNonNull(
                            getActivity()).getContentResolver().openInputStream(Objects.requireNonNull(uri)));
                    Log.d(TAG, "onActivityResult: metadata.toString(): " + metadata.toString());
                    for(Directory directory: metadata.getDirectories()){
                        Log.d(TAG, "onActivityResult: tags: " + directory.getTags());////getting all data
                    }
                } catch (ImageProcessingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void performFileSearch() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }
}
