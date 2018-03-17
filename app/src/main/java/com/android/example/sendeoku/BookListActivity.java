package com.android.example.sendeoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.example.sendeoku.dummy.DetailActivity;
import com.android.example.sendeoku.dummy.DummyContent;

public class BookListActivity extends AppCompatActivity implements BookFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id", item.id);
        intent.putExtra("content", item.content);
        intent.putExtra("details", item.details);
        startActivity(intent);
    }
}
