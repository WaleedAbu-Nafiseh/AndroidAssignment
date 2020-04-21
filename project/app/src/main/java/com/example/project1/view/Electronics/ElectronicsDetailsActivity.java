package com.example.project1.view.Electronics;

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
import com.example.project1.model.Electronics.ElectronicsDAO;
import com.example.project1.model.Electronics.ElectronicsItem;
import com.example.project1.model.abstractData.AbstractItem;
import com.example.project1.view.MainActivity;
import com.example.project1.view.cars.CarDetailsActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ElectronicsDetailsActivity extends AppCompatActivity {

    TextView electronicName;
    TextView electronicDescription;
    ImageView electronicImg;
    ElectronicsItem selectedElectronicDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_details);

        electronicName = findViewById(R.id.electronicName);
        electronicDescription = findViewById(R.id.electronicDescription);
        electronicImg = findViewById(R.id.electronic_image);


        Intent intent = getIntent();
        int id = (int) intent.getExtras().get("electronic_id");
        System.out.println("id------------------>" + id);
        selectedElectronicDetails = (ElectronicsItem) ElectronicsDAO.getItemByID(id);
        System.out.println("selectedElectronicDetails --------------------->" + selectedElectronicDetails);
        electronicImg.setImageResource(selectedElectronicDetails.getImageID());
        electronicDescription.setText(selectedElectronicDetails.getDescription());
        electronicName.setText(selectedElectronicDetails.getItemName());


    }

    public void selectElectronicItem(View view) {
        //get the whole list from teh shared preferences

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String JSON = prefs.getString("selectedItemsFile","");
        Type type =new TypeToken<ArrayList<AbstractItem>>(){}.getType();
        ArrayList<AbstractItem> selectedItems = gson.fromJson(JSON,type);

        selectedItems.add(selectedElectronicDetails);



        //Write to the File
        Gson gsonR = new Gson();
        SharedPreferences prefsR = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefsR.edit();

        String selectedItemsJSON = gson.toJson(selectedItems);
        editor.putString("selectedItemsFile",selectedItemsJSON);
        editor.commit();
        Toast.makeText(this, "The Item Selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(ElectronicsDetailsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
