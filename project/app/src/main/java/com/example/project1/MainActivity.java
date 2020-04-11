package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.project1.cars.CarListActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private  ArrayList storesList;
    private ArrayAdapter<String> storesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.lstVwStoresList);
        storesList = new ArrayList<String>();
        storesList.add("Cars");
        storesList.add("First two");
        storesList.add("First three");
        storesList.add("First four");
        storesListAdapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_spinner_item, storesList);
        list.setAdapter(storesListAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(MainActivity.this, CarListActivity.class);
                    startActivity(intent);
                }
            }
        };
        list.setOnItemClickListener(itemClickListener);
    }

}
