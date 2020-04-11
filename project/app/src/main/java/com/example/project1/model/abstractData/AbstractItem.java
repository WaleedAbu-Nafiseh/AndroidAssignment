package com.example.project1.model.abstractData;

import androidx.annotation.NonNull;

/*This Class is an abstract Item list that should be further extended to be able to add all selected Iems from different types into the same string
dadwa*/
public class AbstractItem {
    String itemName;
    String description;
    int imageID;
    int price ;

    public AbstractItem() {
    }

    public AbstractItem(String itemName, String description, int imageID, int price) {
        this.itemName = itemName;
        this.description = description;
        this.imageID = imageID;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return this.itemName;
    }
}
