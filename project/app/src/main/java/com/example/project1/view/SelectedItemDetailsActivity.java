package com.example.project1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SelectedItemDetailsActivity extends AppCompatActivity {
    AbstractItem selectedItem ;
    ImageView imgSelected;
    TextView txtSelectedName;
    TextView txtSelectedPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item_details);
        imgSelected=findViewById(R.id.imgSelected);
        txtSelectedName=findViewById(R.id.txtSelectedName);
        txtSelectedPrice=findViewById(R.id.txtSelectedPrice);

        Intent intent = getIntent();
        int position= (int) intent.getExtras().get("selectedItemPosition");

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("selectedItemsFile","");
        Type type =new TypeToken<ArrayList<AbstractItem>>(){}.getType();
        ArrayList<AbstractItem> selectedItemsList = gson.fromJson(JSON,type);

        selectedItem= selectedItemsList.get(position);
        Log.e("",selectedItem.getItemName());
        txtSelectedName.setText(selectedItem.getItemName());

        txtSelectedPrice.setText(selectedItem.getPrice()+"");
        imgSelected.setImageResource(selectedItem.getImageID());

    }
}
