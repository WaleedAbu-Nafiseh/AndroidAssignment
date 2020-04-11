package com.example.project1.view.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;

public class CarDetailsActivity extends AppCompatActivity {
    TextView txtCarName;
    TextView txtCarPrice;
    ImageView imgCar;

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
        imgCar .setImageResource(car.getImageID());
        txtCarName.setText( car.getItemName());
        txtCarPrice.setText(car.getPrice()+"");

    }
}
