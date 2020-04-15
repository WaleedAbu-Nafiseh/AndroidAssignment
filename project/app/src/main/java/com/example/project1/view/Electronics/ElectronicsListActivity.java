package com.example.project1.view.Electronics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Electronics.ElectronicsDAO;
import com.example.project1.model.abstractData.AbstractItem;

import java.util.ArrayList;

public class ElectronicsListActivity extends AppCompatActivity {
    private ArrayList<AbstractItem> electronicsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_list);

        electronicsList = new ArrayList<>();
        electronicsList.addAll(ElectronicsDAO.getElectronicsList());

        ArrayAdapter<AbstractItem> electronicsListAdapter = new ArrayAdapter<AbstractItem>(this,
                android.R.layout.simple_list_item_1,
                electronicsList
        );

        ListView electronicsListView = findViewById(R.id.electronics_list);
        electronicsListView.setAdapter(electronicsListAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ElectronicsListActivity.this, ElectronicsDetailsActivity.class);
                intent.putExtra("electronic_id", (int) id);
                ElectronicsListActivity.this.startActivity(intent);
            }
        };
        electronicsListView.setOnItemClickListener(itemClickListener);
    }
}
