package com.example.project1.view.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.abstractData.AbstractItem;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CarDetailsActivity extends AppCompatActivity {
    TextView txtCarName;
    TextView txtCarPrice;
    ImageView imgCar;
    private ArrayList carsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        txtCarName= findViewById(R.id.txtCarName);
        txtCarPrice= findViewById(R.id.txtPrice);
        imgCar= findViewById(R.id.imgCar);
        Intent intent = getIntent();
        int position= (int) intent.getExtras().get("carPosition");
        CarItem car= (CarItem) CarsDAO.getItemFromID(position);
        imgCar.setImageResource(car.getImageID());
        txtCarName.setText( car.getItemName());
        txtCarPrice.setText(car.getPrice()+"");

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("carsList","");
        AbstractItem[] abs= gson.fromJson(JSON,CarItem[].class);
        for (int i=0;i<abs.length;i++){
            Log.e("e", abs[i].getItemName());
        }

    }
}
