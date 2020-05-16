package com.example.project1.view.cars;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarsDAO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class CarListFragment extends Fragment {
    private ListView list;
    private  ArrayList carsList;
    private ArrayAdapter<String> carsListAdapter;

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
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor=prefs.edit();
        String carsJSON = gson.toJson(CarsDAO.getCarsList());
        editor.putString("carsList",carsJSON);
        editor.commit();
        View view = getView();

        if(view !=null){
            list = view.findViewById(R.id.lstvwCarsList1);

            carsList = new ArrayList<String>();
            carsList.addAll(Arrays.asList(CarsDAO.getCarsList()));

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
            list.setOnItemClickListener(itemClickListener);
        }
    }
}