package com.example.project1.model.Electronics;

import com.example.project1.model.abstractData.AbstractItem;

public class ElectronicsItem extends AbstractItem {
    String model;
    String color;

    public ElectronicsItem() {
        super();
    }
    public ElectronicsItem(String itemName, String description, int imageID, int price, String model, String color) {
        super(itemName, description, imageID, price);
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
