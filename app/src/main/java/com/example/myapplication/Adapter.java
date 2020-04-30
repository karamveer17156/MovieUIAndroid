package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private static Context cont;
    private String[] sTitles;


    Adapter(Context context, String[] titles){
        this.inflater = LayoutInflater.from(context);
        this.sTitles = titles;
        cont = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.activity_movie_card,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = sTitles[i];
//        System.out.println(title);
        viewHolder.storyTitle.setText(title);
        String temp = "  "+ title.charAt(0);
        viewHolder.tf.setText(temp);
        viewHolder.buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start a new activity
                Intent intent = new Intent(cont, Transactions.class);
                cont.startActivity(intent);
            }
        });

        viewHolder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start a new activity
                Intent intent = new Intent(cont, Cart_view.class);
                cont.startActivity(intent);
            }
        });



    }
    @Override
    public int getItemCount() {
        return sTitles.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        //tf is first char in BB
        TextView storyTitle,tf, cart, buy_now, price, rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//             implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Details_movie.class);
                    // send story title and contents through recyclerview to detail activity
                    i.putExtra("titleOfStory",sTitles[getAdapterPosition()]);
//                    i.putExtra("contentOfStory",sContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            storyTitle = itemView.findViewById(R.id.title);
            tf = itemView.findViewById(R.id.image_char);
            buy_now = itemView.findViewById(R.id.buy_now);
            price = itemView.findViewById(R.id.price_rate);
            rating = itemView.findViewById(R.id.rating);
            cart = itemView.findViewById(R.id.addToCart);


        }
    }
}