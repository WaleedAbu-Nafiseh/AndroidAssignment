package com.example.project1.model.Cars;

import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;

public class CarsDAO {
    private static  AbstractItem[] items;
    private static void createCarList(){
        items= new AbstractItem[]{
                new CarItem("BMW", "This is an amazingly Fast Car", R.drawable.bmw_car, 54584, "X2", 1998),
                new CarItem("Mercides", "The best Car", R.drawable.bmw_car, 4181500, "maybach", 2020),
                new CarItem("Hyundai", "Very New Conditions", R.drawable.bmw_car, 36452, "Accent 1.4", 2010),
                new CarItem("TOYOTA", "Fast Car", R.drawable.bmw_car, 51475, "TOYNEW", 2007),
                new CarItem("BMW", "This is an new Fast Car", R.drawable.bmw_car, 125144, "X1", 2013),
        };
    }
    public  static AbstractItem[] getCarsList(){
        createCarList();
        return items;
    }
}

