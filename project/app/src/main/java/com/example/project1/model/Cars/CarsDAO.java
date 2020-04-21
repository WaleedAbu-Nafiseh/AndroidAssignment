package com.example.project1.model.Cars;

import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;

public class CarsDAO {
    private static  AbstractItem[] items;

    private static void createCarList(){
        items= new AbstractItem[]{
                new CarItem("BMW X1", "This is an amazingly Fast Car", R.drawable.x2, 54584, "X2", 1998),
                new CarItem("Mercides", "The best Car", R.drawable.mayback, 4181500, "maybach", 2020),
                new CarItem("Hyundai", "Very New Conditions", R.drawable.hyundai, 36452, "Accent 1.4", 2010),
                new CarItem("TOYOTA", "refurbeshed Car", R.drawable.toyota, 51475, "TOYNEW", 2007),
                new CarItem("BMW X1" , "This is a brand new  Car", R.drawable.bmw_car, 125144, "X1", 2013),
        };
    }
    public  static AbstractItem[] getCarsList(){
        createCarList();
        return items;
    }
    public static AbstractItem getItemFromID( int position){
        return items[position];
    }
}

