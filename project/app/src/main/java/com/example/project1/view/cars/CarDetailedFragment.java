package com.example.project1.view.cars;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.model.Cars.CarItem;
import com.example.project1.model.Cars.CarsDAO;

public class CarDetailedFragment extends Fragment {
    TextView txtCarName;
    TextView txtCarPrice;
    ImageView imgCar;
    CarItem car;

    public CarDetailedFragment() {
        // Required empty public constructor
    }

    public static CarDetailedFragment newInstance(String param1, String param2) {
        CarDetailedFragment fragment = new CarDetailedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getView();
        if(view !=null) {
            txtCarName= view.findViewById(R.id.txtCarName1);
            txtCarPrice= view.findViewById(R.id.txtPrice1);
            imgCar= view.findViewById(R.id.imgCar1);
            Intent intent = getActivity().getIntent();
            int position= (int) intent.getExtras().get("carPosition");
            car= (CarItem) CarsDAO.getItemFromID(position);
            imgCar.setImageResource(car.getImageID());
            txtCarName.setText( car.getItemName());
            txtCarPrice.setText(car.getPrice()+"");
        }
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_detailed2, container, false);
    }
}
