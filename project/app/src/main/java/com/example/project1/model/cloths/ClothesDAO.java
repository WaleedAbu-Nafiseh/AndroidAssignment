package com.example.project1.model.cloths;

import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;

import java.util.ArrayList;

public class ClothesDAO {

    private static ArrayList<AbstractItem> clothes ;


    private static void getClothesItem() {
        clothes = new ArrayList<>();
        clothes.add(new ClothesItem("Pant","Green formal women's pants", R.drawable.mangopant,100,"Brand--> Mango","Size--> Medium","10% OFF"));
        clothes.add(new ClothesItem("Shirt","Summer women's shirt", R.drawable.hmshirt,180,"Brand--> H&M","Size--> Large","50% OFF"));
        clothes.add(new ClothesItem("Jacket","A luxurious black leather jacket", R.drawable.zarajacket,300,"Brand--> Zara","Size--> Small","No Sale On This Item "));
    }
    public static ArrayList<AbstractItem> getClothesList() {
        getClothesItem();
        return clothes;
    }
    public static AbstractItem getItemByID(int position) {
        return clothes.get(position);
    }
}




