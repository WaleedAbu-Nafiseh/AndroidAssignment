package com.example.project1.model.Food;

import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;

import java.util.LinkedList;

public class FoodDAO {
    //array list for Data
    private static LinkedList<AbstractItem> foods = new LinkedList<AbstractItem>();
private static void FoodList(){
foods.add(new FoodItem("Pizza" , " consisting of a flattened disk of bread dough topped with some combination of vegitables . "
        , R.drawable.pizza , 100 , "Chef Ahmad " , "dish of Italian origin")) ;
foods.add(new FoodItem("sandwiches" , "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread" , R.drawable.sandwich , 50 , "Chef Muna" , "American dish"));
foods.add(new FoodItem("burger" , " a food item consisting of a cooked meat and bun" , R.drawable.burger , 70 , "Chef Adel " , "Fast Food "));
}

public static LinkedList<AbstractItem> getFoodList (){
    FoodList();
    return foods ;
}
    public static AbstractItem getItemFromID( int position){
        return foods.get(position);
    }

}
