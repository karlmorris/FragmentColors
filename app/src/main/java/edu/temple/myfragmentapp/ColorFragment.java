package edu.temple.myfragmentapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class ColorFragment extends Fragment {

    View l;
    String[] colors;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        l =  inflater.inflate(R.layout.fragment_color, container, false);
        colors = new String[]{"Blue", "Red", "Yellow", "Magenta", "Green", "Cyan"};

        l.findViewById(R.id.changeColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentActivity.buttonClick(ColorFragment.this);
            }
        });

        changeColor();

        return l;
    }

    public void changeColor() {
        l.setBackgroundColor(Color.parseColor(colors[(new Random()).nextInt(colors.length)]));
    }

    interface ButtonClickInterface {
        void buttonClick(ColorFragment colorFragment);
    }
}