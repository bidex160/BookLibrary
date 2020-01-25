package com.example.booklibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

  ArrayList<BOOKS> books = new ArrayList<>();

  Context context;

    public RecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelayout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
     holder.bookname.setText(books.get(position).getName());
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             int x = books.get(position).getId();
             Intent intent = new Intent(context, BookActivity.class);
             intent.putExtra("bookid", books.get(position).getId());
             context.startActivity(intent);
         }
     });

     holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             Intent intentalredy = new Intent(context, AlreadyReadBook.class);

             Intent intentwanto = new Intent(context, WantToReadBook.class);

             intentwanto.putExtra("bkid", books.get(position).getId());

             intentalredy.putExtra("bkid", books.get(position).getId());

             context.startActivity(intentalredy);
             context.startActivity(intentwanto);

             return false;
         }
     });

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageurl())
                .into(holder.bookimg);
    }




    @Override
    public int getItemCount() {

        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    private ImageView bookimg;
    private TextView bookname;
    private CardView cardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        bookimg =(ImageView)itemView.findViewById(R.id.imgv);
        bookname=(TextView) itemView.findViewById(R.id.bookname);
        cardView=(CardView)itemView.findViewById(R.id.cardv);
    }
}

    public void setBooks(ArrayList<BOOKS> books) {
        this.books = books;
        notifyDataSetChanged();
    }

}
