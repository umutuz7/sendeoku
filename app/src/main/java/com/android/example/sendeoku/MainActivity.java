package com.android.example.sendeoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.example.sendeoku.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements BookFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
