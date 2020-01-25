package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class AlreadyReadBook extends AppCompatActivity {
    RecyclerView recyclerView;
    private BOOKS Incomingbk;
    private  Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recycleviewal);

        RecycleViewAdapter adapter = new RecycleViewAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

       util = new Util();

        ArrayList<BOOKS> books = util.getAlreadyread();

        adapter.setBooks(books);

        Intent intent = getIntent();
        int alreadyId = intent.getIntExtra("bkid", 0);



//        Intent intent2 = new Intent(this, WantToReadBook.class);
       // intent2.putExtra("bkid", alreadyId);
        //startActivity(intent2);


        boolean doex = false;


        for(BOOKS bk: books){
            if(bk.getId() == alreadyId){
                 Incomingbk = bk;
                doex = true;

            }

        }
        if(doex){
            util.removealreadread(Incomingbk);
            Toast.makeText(this, "Removed Succesfully", Toast.LENGTH_LONG).show();

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
