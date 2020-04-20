package com.example.project1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.view.Electronics.ElectronicsListActivity;
import com.example.project1.view.Food.FoodListActivity;
import com.example.project1.view.cars.CarDetailsActivity;
import com.example.project1.view.cars.CarListActivity;
import com.example.project1.view.cloths.ClothesListActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SelectedItemsActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<AbstractItem> SelectedItemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_selected_items);
        list = findViewById(R.id.lstvwSelectedItems);

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("selectedItemsFile","");
        Type type =new TypeToken<ArrayList<AbstractItem>>(){}.getType();
        ArrayList<AbstractItem> selectedItems = gson.fromJson(JSON,type);

        SelectedItemsAdapter = new ArrayAdapter<AbstractItem>(getApplicationContext(),
                android.R.layout.simple_spinner_item, selectedItems);
        list.setAdapter(SelectedItemsAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectedItemsActivity.this, SelectedItemDetailsActivity.class);
                intent.putExtra("selectedItemPosition",position);
                startActivity(intent);

            }
        };
        list.setOnItemClickListener(itemClickListener);

    }

    public void goHome(View view) {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
