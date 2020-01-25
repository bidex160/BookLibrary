package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclev);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));




    //    books.add(new BOOKS("JAVA", "BIDEX", 1,"https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Recycleview"));
       // books.add(new BOOKS("JAVA", "BIDEX", 1,"https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Recycleview"));
    //    books.add(new BOOKS("JAVA", "BIDEX", 1,"https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Recycleview"));
     //   books.add(new BOOKS("JAVA", "BIDEX", 1,"https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","Recycleview"));
        Util util = new Util();
        ArrayList<BOOKS> books = new ArrayList<>();
        books = util.getAllbooks();
        recycleViewAdapter.setBooks(books);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
                default:
                    break;
        }

        return super.onOptionsItemSelected(item);
    }
}
