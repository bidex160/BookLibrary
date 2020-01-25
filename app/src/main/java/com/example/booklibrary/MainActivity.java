package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button allBt, currentBt,wantBt, aboutBt, alreadyBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allBt = (Button)findViewById(R.id.AllBt);
        currentBt = (Button)findViewById(R.id.CurrentBt);
        wantBt = (Button)findViewById(R.id.WantBt);
        aboutBt = (Button)findViewById(R.id.AboutBt);
        alreadyBt = (Button)findViewById(R.id.Alreadbt);


    }
    public void About(View view){

        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
    public void wanttoread(View view){
        Intent intent = new Intent(MainActivity.this, WantToReadBook.class);
        startActivity(intent);


    }
    public void Already(View view){

        Intent intent = new Intent(MainActivity.this, AlreadyReadBook.class);
        startActivity(intent);
    }
    public void current(View view){
        Intent intent = new Intent(MainActivity.this, CurrentlyReadingBooks.class);
        startActivity(intent);

    }

    public void All(View view){
        Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
        startActivity(intent);

    }
}
