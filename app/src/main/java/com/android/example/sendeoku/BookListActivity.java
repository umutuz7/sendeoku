package com.android.example.sendeoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.example.sendeoku.dummy.DetailActivity;
import com.android.example.sendeoku.dummy.DummyContent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookListActivity extends AppCompatActivity implements BookFragment.OnListFragmentInteractionListener {

    public static String TAG = "TAG";

    DatabaseReference myRef;

    BookFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        fragment = (BookFragment) getFragmentManager().findFragmentById(R.id.bookFragment);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
//        myRef.setValue("");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Iterator<DataSnapshot> iterator = dataSnapshot.child("book").getChildren().iterator();
                List<DummyContent.DummyItem> items = new ArrayList<>();
                while (iterator.hasNext()) {
                    DummyContent.DummyItem value = iterator.next().getValue(DummyContent.DummyItem.class);
                    items.add(value);
                    Log.d(TAG, "Value is: " + value.id);
                }
                fragment.addBook(items);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra
                ("id", item.id);
        intent.putExtra("content", item.content);
        intent.putExtra("details", item.details);
        startActivity(intent);
    }
}
