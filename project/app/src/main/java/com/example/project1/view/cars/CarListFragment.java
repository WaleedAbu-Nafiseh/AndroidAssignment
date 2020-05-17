package com.example.project1.view.cars;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CaptionedCarsAdapter;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;
import com.example.project1.model.abstractData.AbstractItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class CarListFragment extends Fragment  implements View.OnClickListener{
    private ListView list;
    private  ArrayList carsList;
    private ArrayAdapter<String> carsListAdapter;
    RecyclerView recycler ;
    public CarListFragment() {
        // Required empty public constructor
    }

    public static CarListFragment newInstance(String param1, String param2) {
        CarListFragment fragment = new CarListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


      }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        carsList = new ArrayList<CarItem>();

        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String JSON = prefs.getString("carsList","");
        Type type =new TypeToken<ArrayList<CarItem>>(){}.getType();
        ArrayList<CarItem> carsList = gson.fromJson(JSON,type);

        View view = getView();

        if(view !=null){

             recycler = (RecyclerView)view.findViewById(R.id.carsRecycler);



            recycler.setLayoutManager(new LinearLayoutManager(getContext()));
            CaptionedCarsAdapter adapter = new CaptionedCarsAdapter(carsList);
            recycler.setAdapter(adapter);
/*
            list = view.findViewById(R.id.lstvwCarsList1);


            Log.e("e",carsList.indexOf(0)+" w");
            carsListAdapter = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, carsList);
            list.setAdapter(carsListAdapter);
            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getContext(), CarDetailsActivity.class);
                    intent.putExtra("carPosition",position);
                    startActivity(intent);
                }
            };
            list.setOnItemClickListener(itemClickListener);*/
        }
    }


    @Override
    public void onClick(View v) {
        int position = recycler.getChildAdapterPosition(v);
        Log.e("TAG", "onClick: position is "+position  );
    }
}