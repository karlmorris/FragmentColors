package edu.temple.myfragmentapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class ColorFragment extends Fragment {

    View l;
    String[] colors;

    int fragmentId;
    String defaultColor;


    private static final String KEY_ID = "fragmentId";
    private static final String KEY_COLOR = "defaultColor";

    ButtonClickInterface parentActivity;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ButtonClickInterface) {
            parentActivity = (ButtonClickInterface) context;
        } else {
            throw new RuntimeException("You must implement ButtonClickInterface to attach this fragment");
        }
    }

    public static ColorFragment newInstance(int fragmentId, String defaultColor) {
        ColorFragment fragment = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ID, fragmentId);
        bundle.putString(KEY_COLOR, defaultColor);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle;
        if ((bundle = getArguments()) != null) {
            fragmentId = bundle.getInt(KEY_ID);
            defaultColor = bundle.getString(KEY_COLOR);
        } else {
            fragmentId = -1;
            defaultColor = "White";
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        l =  inflater.inflate(R.layout.fragment_color, container, false);
        colors = new String[]{"Blue", "Red", "Yellow", "Magenta", "Green", "Cyan"};

        l.findViewById(R.id.changeColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentActivity.buttonClick(fragmentId);
            }
        });

        if (defaultColor != null) {
            l.setBackgroundColor(Color.parseColor(defaultColor));
        }

        //changeColor();

        return l;
    }

    public void changeColor() {
        l.setBackgroundColor(Color.parseColor(colors[(new Random()).nextInt(colors.length)]));
    }

    public int getFragmentId () {
        return fragmentId;
    }

    interface ButtonClickInterface {
        void buttonClick(int fragmentId);
    }
}