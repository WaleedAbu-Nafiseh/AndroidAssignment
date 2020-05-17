package com.example.project1.model.Cars;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.view.cars.CarListActivityfrg;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CaptionedCarsAdapter extends RecyclerView.Adapter<CarListActivityfrg.ViewHolder>  {
    ArrayList<CarItem> carsList;


    public CaptionedCarsAdapter(ArrayList<CarItem> carsList) {
    this.carsList=carsList;

    }

    @NonNull
    @Override
    public CarListActivityfrg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.carlayout,parent,false);

        return new CarListActivityfrg.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListActivityfrg.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView  imageView = cardView.findViewById(R.id.imgCaritem);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(),carsList.get(position).getImageID());
        imageView.setImageDrawable(dr);
        TextView txtName= cardView.findViewById(R.id.txtCardName);
        TextView txtDes = cardView.findViewById(R.id.txtCardDes);
        txtName.setText(carsList.get(position).getItemName());
        txtDes.setText(carsList.get(position).getDescription());
       /* cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // get position
                int pos = v.getVerticalScrollbarPosition();

                // check if item still exists
                if(pos != RecyclerView.NO_POSITION){
                    RvDataItem clickedDataItem = dataItems.get(pos);
                    Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }



    @Override
    public int getItemCount() {
        return carsList.size();
    }



}
