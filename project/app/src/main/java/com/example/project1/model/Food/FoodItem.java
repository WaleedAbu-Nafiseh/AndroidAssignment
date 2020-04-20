package com.example.project1.model.Food;

import com.example.project1.model.abstractData.AbstractItem;

public class FoodItem extends AbstractItem {

    String chefName ;
    String foodType ;

    public FoodItem(){
        super();
    }

    public FoodItem(String itemName, String description, int imageID, int price, String chefName, String foodType) {
        super(itemName, description, imageID, price);
        this.chefName = chefName;
        this.foodType = foodType;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


}
