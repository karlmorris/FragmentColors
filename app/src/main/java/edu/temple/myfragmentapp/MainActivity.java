package edu.temple.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ColorFragment.ButtonClickInterface {

    ColorFragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ColorFragment[4];

        fragments[0] = new ColorFragment();
        fragments[1] = new ColorFragment();
        fragments[2] = new ColorFragment();
        fragments[3] = new ColorFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, fragments[0])
                .add(R.id.container_2, fragments[1])
                .add(R.id.container_3, fragments[2])
                .add(R.id.container_4, fragments[3])
                .commit();
    }

    public void buttonClick(ColorFragment clickedFragment) {
        for (ColorFragment fragment : fragments) {
            if (clickedFragment != fragment)
                fragment.changeColor();
        }
    }
}