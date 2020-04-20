package com.example.project1.view.Food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.Electronics.ElectronicsDAO;
import com.example.project1.model.Food.FoodDAO;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.view.Electronics.ElectronicsDetailsActivity;
import com.example.project1.view.Electronics.ElectronicsListActivity;
import com.example.project1.view.cars.CarDetailsActivity;
import com.example.project1.view.cars.CarListActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodListActivity extends AppCompatActivity {
private ListView foodList ;
    private ArrayList <AbstractItem> foodArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        foodList= findViewById(R.id.ListFood);

        foodArrayList =  new ArrayList<>();
        foodArrayList.addAll(FoodDAO.getFoodList());


        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefs.edit();
        String FoodJSON= gson.toJson(FoodDAO.getFoodList());
        editor.putString("FoodList",FoodJSON);
        editor.commit();



        ArrayAdapter<AbstractItem> foodListAdapter = new ArrayAdapter<AbstractItem>(this,
                android.R.layout.simple_list_item_1,
                foodArrayList
        );


        foodList.setAdapter(foodListAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FoodListActivity.this, FoodDetailsActivity.class);
                intent.putExtra("FoodPosition",position);
                startActivity(intent);

            }
        };
        foodList.setOnItemClickListener(itemClickListener);

    }
}
