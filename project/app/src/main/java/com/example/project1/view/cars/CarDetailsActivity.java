package com.example.project1.view.cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CarDetailsActivity extends AppCompatActivity {
    TextView txtCarName;
    TextView txtCarPrice;
    ImageView imgCar;
    CarItem car ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        txtCarName= findViewById(R.id.txtCarName);
        txtCarPrice= findViewById(R.id.txtPrice);
        imgCar= findViewById(R.id.imgCar);
        Intent intent = getIntent();
        int position= (int) intent.getExtras().get("carPosition");
        car= (CarItem) CarsDAO.getItemFromID(position);
        imgCar.setImageResource(car.getImageID());
        txtCarName.setText( car.getItemName());
        txtCarPrice.setText(car.getPrice()+"");

    }

    public void selectItem(View view) {
    //get the whole list from teh shared preferences

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("selectedItemsFile","");
        Type type =new TypeToken<ArrayList<AbstractItem>>(){}.getType();
        ArrayList<AbstractItem> selectedItems = gson.fromJson(JSON,type);

        selectedItems.add(car);


        //Write to the File
        Gson gsonR = new Gson();
        SharedPreferences prefsR = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefsR.edit();

        String selectedItemsJSON = gsonR.toJson(selectedItems);
        editor.putString("selectedItemsFile",selectedItemsJSON);
        editor.commit();
        Toast.makeText(this, "The Item Selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(CarDetailsActivity.this, MainActivity.class);
        startActivity(intent);

    }


}
