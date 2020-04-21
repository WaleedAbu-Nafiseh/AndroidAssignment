package com.example.project1.view.Food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.Food.FoodDAO;
import com.example.project1.model.Food.FoodItem;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.view.MainActivity;
import com.example.project1.view.cars.CarDetailsActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FoodDetailsActivity extends AppCompatActivity {
    TextView foodName;
    TextView FoodPrice;
    ImageView FoodImg ;
    TextView foodDetils ;
     Switch delivery;
    FoodItem food ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        foodName = findViewById(R.id.foodName);
       FoodPrice = findViewById(R.id.FoodPrice);
        FoodImg=   findViewById(R.id.FoodImg);
        delivery = findViewById(R.id.delevary) ;
        foodDetils = findViewById(R.id.FoodDetails) ;

        Intent intent = getIntent();
        int position= (int) intent.getExtras().get("FoodPosition");
         food= (FoodItem) FoodDAO.getItemFromID(position);
        FoodImg .setImageResource(food.getImageID());
        foodName.setText("food Name : " + food.getItemName());
        FoodPrice.setText("The Price is "+food.getPrice()+"$");
        foodDetils.setText(" Discribtion : "+food.getDescription());

        Boolean swtDelivary = delivery.isChecked();
        //switch
        if(swtDelivary){
            delivery.setChecked(true);
            Toast.makeText(this, " Delivary Service is activated", Toast.LENGTH_LONG).show();

        }
        else{
            delivery.setChecked(false);

        }


        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("FoodList","");
        AbstractItem[] abs= gson.fromJson(JSON,FoodItem[].class);



    }
    public void selectFoodItem(View view) {
        //get the whole list from teh shared preferences

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("selectedItemsFile","");
        Type type =new TypeToken<ArrayList<AbstractItem>>(){}.getType();
        ArrayList<AbstractItem> selectedItems = gson.fromJson(JSON,type);


        selectedItems.add(food);


        //Write to the File
        Gson gsonR = new Gson();
        SharedPreferences prefsR = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefsR.edit();

        String selectedItemsJSON = gson.toJson(selectedItems);
        editor.putString("selectedItemsFile",selectedItemsJSON);
        editor.commit();
        Toast.makeText(this, "The Item Selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(FoodDetailsActivity.this, MainActivity.class);
        startActivity(intent);    }

}
