package com.example.project1.model.Electronics;

import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;

import java.util.ArrayList;

public class ElectronicsDAO {
    private static ArrayList<AbstractItem> electronicItems = new ArrayList<>();

    private static void getElectronicsItems() {

        electronicItems.add(new ElectronicsItem("Playstation 1", " video game console released in 1994 by Sony Computer Entertainmen",
                R.drawable.sony_playstation, 500, "Playstation", "Gray"));
        electronicItems.add(new ElectronicsItem("OMEN Laptop", "Stunning desktop-grade power in a sleek, portable design keeps you playing your best wherever gaming takes you",
                R.drawable.omen_laptop, 5000, "Laptop", "Black"));
        electronicItems.add(new ElectronicsItem("Mechanical Gaming Keyboard", " built with high quality",
                R.drawable.mechanical_keyboard, 900, "Keyboard", "Black"));
    }

    public static ArrayList<AbstractItem> getElectronicsList() {
        getElectronicsItems();
        return electronicItems;
    }

    public static AbstractItem getItemByID(int position) {
        return electronicItems.get(position);
    }
}
