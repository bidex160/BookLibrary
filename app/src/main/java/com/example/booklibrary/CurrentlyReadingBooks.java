package com.example.booklibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class CurrentlyReadingBooks extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Util util;
    private BOOKS incd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_books);

        Intent intent = getIntent();
        int x = intent.getIntExtra("bkid", 0);

        //   ArrayList<BOOKS> bookz = util.getCurrently();




             //         }
        //     if (true){
             //    util.removecurrent(incd);

             //      Toast.makeText(this, "Removed Succesfully", Toast.LENGTH_SHORT).show();
       //  }



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclevw);
        CurrentAdapter adapter = new CurrentAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


         util = new Util();
        ArrayList<BOOKS> books = new ArrayList<>();
        books = util.getCurrently();

        adapter.setBooks(books);

          boolean dex = false;
        for (BOOKS b: books) {

            if (b.getId() == x) {
             incd = b;
             dex=true;

            }
        }
        if (dex){

            util.removecurrent(incd);
            Toast.makeText(this, incd.getName(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
             default:
                 break;

        }
        return super.onOptionsItemSelected(item);
    }
}
