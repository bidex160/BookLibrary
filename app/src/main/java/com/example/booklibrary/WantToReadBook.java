package com.example.booklibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class WantToReadBook extends AppCompatActivity {
    RecyclerView recyclerView;
    private BOOKS wantbk;
    private Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclev);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        util = new Util();

        //Intent intent = getIntent();
        int x = 2;//intent.getIntExtra("bkid", 0);

        ArrayList<BOOKS> books = new ArrayList<>();

        books = util.getWanttoread();

        adapter.setBooks(books);


        boolean doexit = false;

        for (BOOKS bk: books){
            if (bk.getId() ==x ) {
                wantbk = bk;
                doexit = true;
            }

        }

        if (doexit){
            util.removewantto(wantbk);
            Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();

           // AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //    builder.setMessage(wantbk.getName() +" " +"Remove Succesfully");
     //       builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
     //           @Override
           //     public void onClick(DialogInterface dialogInterface, int i) {
//
                }
    //        });
    //        builder.setCancelable(false);
     //       builder.create().show();
     //   }
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
