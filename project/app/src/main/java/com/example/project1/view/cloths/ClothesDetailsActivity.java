package com.example.project1.view.cloths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1.R;
import com.example.project1.model.Electronics.ElectronicsDAO;
import com.example.project1.model.Electronics.ElectronicsItem;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.model.cloths.ClothesDAO;
import com.example.project1.model.cloths.ClothesItem;
import com.example.project1.view.MainActivity;
import com.example.project1.view.cars.CarDetailsActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClothesDetailsActivity extends AppCompatActivity {
    ImageView img;
    TextView BrandName;
    TextView size;
    TextView sale;
    ClothesItem Cloth;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_details);
        BrandName=findViewById(R.id.BrandName);
        size=findViewById(R.id.itemSize);
        sale=findViewById(R.id.itemsale);
        img=findViewById(R.id.clothesimage);
        Intent intent=getIntent();
        int id= (int) intent.getExtras().get("Cloth_id");
        Cloth=(ClothesItem) ClothesDAO.getItemByID(id);
        img.setImageResource(Cloth.getImageID());
        BrandName.setText(Cloth.getBrandName());
        size.setText(Cloth.getSize());
        sale.setText(Cloth.getSale());
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClothesDetailsActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
    public void selectClothItem(View view) {
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("selectedItemsFile","");
        Type type =new TypeToken<ArrayList<AbstractItem>>(){}.getType();
        ArrayList<AbstractItem> selectedItems = gson.fromJson(JSON,type);

        selectedItems.add(Cloth);




        Gson gsonR = new Gson();
        SharedPreferences prefsR = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefsR.edit();

        String selectedItemsJSON = gsonR.toJson(selectedItems);
        editor.putString("selectedItemsFile",selectedItemsJSON);
        editor.commit();
        Toast.makeText(this, "The Item Selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(ClothesDetailsActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
