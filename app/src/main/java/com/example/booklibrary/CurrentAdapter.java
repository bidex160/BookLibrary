package com.example.booklibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.ViewHolder>{

    private ArrayList<BOOKS> books = new ArrayList<>();
    Context context;

    public CurrentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycletwo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.cbkname.setText(books.get(position).getName());
        int x = books.get(position).getPages();
       holder.cpages.setText(String.valueOf(x));
        holder.cbkautor.setText(books.get(position).getAuthor());
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int y = books.get(position).getId();
                    Intent intent = new Intent(context, CurrentlyReadingBooks.class);
                      intent.putExtra("bkid", books.get(position).getId());
                        context.startActivity(intent);


                return false;
            }
        });
         //   @Override
          //  public void onClick(View view) {
              //  int y = books.get(position).getId();
            //    Intent intent = new Intent(context, CurrentlyReadingBooks.class);
          //      intent.putExtra("bkid", books.get(position).getId());
        //        context.startActivity(intent);


         //   }
    //    });

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageurl())
                .into(holder.cbookimg);



    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cbookimg;
        private TextView cbkname;
        private TextView cbkautor;
        private TextView cpages;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cbookimg =(ImageView)itemView.findViewById(R.id.cimgv);
            cbkname =(TextView) itemView.findViewById(R.id.cbookname);
            cardView=(CardView)itemView.findViewById(R.id.cardvv);
             cbkautor =(TextView) itemView.findViewById(R.id.cbookauthor);
            cpages =(TextView) itemView.findViewById(R.id.cbookpages);
        }
    }

    public void setBooks(ArrayList<BOOKS> books) {
        this.books = books;
        notifyDataSetChanged();
    }
}
