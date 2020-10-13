package edu.temple.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity implements ColorFragment.ButtonClickInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (!(getSupportFragmentManager().findFragmentById(R.id.container) instanceof ColorFragment))
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, ColorFragment.newInstance(12345, "Red"))
                    .addToBackStack(null)
                    .commit();

    }

    @Override
    public void buttonClick(int fragmentId) {

    }
}