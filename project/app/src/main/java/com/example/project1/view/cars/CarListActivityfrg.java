package com.example.project1.view.cars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.example.project1.R;
import com.example.project1.model.Cars.CarsDAO;
import com.google.gson.Gson;

public class CarListActivityfrg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list_activityfrg2);
        Log.e("e","Here");
        Gson gson1 = new Gson();
        SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefs1.edit();
        String carsJSON = gson1.toJson(CarsDAO.getCarsList());
        editor.putString("carsList",carsJSON);
        editor.commit();

    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public ViewHolder(final CardView cardView){
            super(cardView);
            this.cardView=cardView;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity context= (Activity) cardView.getContext();

                    Log.d("RecyclerView", "onClick：" + getAdapterPosition());
                    Intent intent = new Intent(cardView.getContext(), CarDetailedActivityfrg.class);
                    intent.putExtra("carPosition",getAdapterPosition());
                    context.startActivity(intent);
                }

            });

        }


    }
}
