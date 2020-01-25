package com.example.booklibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private TextView bknames, bkdesc, bkauthor;
    private ImageView bkimg;
    private Button currentrd, wantord, alreadyrd;
    private Util util;
    private BOOKS newbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initwidgets();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookid", 0);
        util = new Util();
        final ArrayList<BOOKS> books = util.getAllbooks();

        for (BOOKS bk : books) {
            if (bk.getId() == id) {
                newbk = bk;
                bknames.setText(bk.getName());
                bkauthor.setText(bk.getAuthor());
                bkdesc.setText(bk.getDescription());

                Glide.with(this)
                        .asBitmap()
                        .load(bk.getImageurl())
                        .into(bkimg);


                //      Toast.makeText(this, "yes", Toast.LENGTH_LONG).show();

            }
        }
        currentrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentbton();
            }
        });

        wantord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WanttoReadBt();
            }
        });

        alreadyrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             alreadybt();
            }
        });

    }
    private void currentbton(){
        ArrayList<BOOKS> cbks= util.getCurrently();
     //   Toast.makeText(this,String.valueOf(cbks.size()), Toast.LENGTH_LONG).show();
        boolean dexist = false;

        for (BOOKS books: cbks) {
            if (books.getId() == newbk.getId()){
                dexist = true;
            }

        }
        if (dexist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Already Added this Book to Current Reading List");
           builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

               }
           });


               builder.setCancelable(false);

            builder.create().show();

        }else{
           boolean x = util.addcurrent(newbk);
            Toast.makeText(this,"Added succesfully", Toast.LENGTH_SHORT).show();

        }
    }
    private void  WanttoReadBt(){
        ArrayList<BOOKS> wanttoread = util.getWanttoread();
        boolean doexist = false;
        for (BOOKS books: wanttoread){

            if (books.getId() == newbk.getId()){
                doexist = true;

            }
        }
        if (doexist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Book Alraedy in Already Read BooKs List");
            builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {


                }
            });
            builder.setCancelable(false);
            builder.create().show();

        }else{

            util.addwanttoread(newbk);
            Toast.makeText(this,"Added succesfully", Toast.LENGTH_SHORT).show();

        }



    }
    public void  alreadybt(){
        ArrayList<BOOKS> AlreadyReadBks = util.getAlreadyread();

        boolean doexist = false;
        for(BOOKS books: AlreadyReadBks){
            if (books.getId() == newbk.getId()){
                doexist = true;
            }

        }

        if (doexist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Alredy Added to Already Read List");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();

        }else {
            util.addalreadread(newbk);
            Toast.makeText(this,"Added succesfully", Toast.LENGTH_SHORT).show();

        }


    }



    private void initwidgets() {
        bknames = (TextView)findViewById(R.id.bknamex);
        bkauthor = (TextView)findViewById(R.id.bkathour);
        bkdesc = (TextView)findViewById(R.id.descripton);
        bkimg =(ImageView)findViewById(R.id.bkimg);

        currentrd=(Button)findViewById(R.id.currentrd);
        wantord=(Button)findViewById(R.id.wanto);
        alreadyrd=(Button)findViewById(R.id.alreadrd);



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
