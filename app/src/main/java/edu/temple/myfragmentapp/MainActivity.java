package edu.temple.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ColorFragment.ButtonClickInterface {

    ColorFragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ColorFragment[4];

        ColorFragment fragment = new ColorFragment();

        Bundle bundle = new Bundle();
        //bundle.putInt(KEY_ID, fragmentId);
        //bundle.putString(KEY_COLOR, defaultColor);
        fragment.setArguments(bundle);

        fragments[0] = ColorFragment.newInstance(0, "Red");
        fragments[1] = ColorFragment.newInstance(1, "Blue");
        fragments[2] = ColorFragment.newInstance(2, "Magenta");
        fragments[3] = ColorFragment.newInstance(3, "Green");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_1, fragments[0])
                .add(R.id.container_2, fragments[1])
                .add(R.id.container_3, fragments[2])
                .add(R.id.container_4, fragments[3])
                .commit();


        //startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    public void buttonClick(int fragmentId) {
        for (ColorFragment fragment : fragments) {
            if (fragmentId != fragment.getFragmentId())
                fragment.changeColor();
        }
    }
}