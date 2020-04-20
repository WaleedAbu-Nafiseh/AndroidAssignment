package com.example.project1.model.cloths;

import com.example.project1.model.abstractData.AbstractItem;

public class ClothesItem extends AbstractItem {
    String brandName;
    String size;
    String sale;
    public ClothesItem() {
    }

    public ClothesItem(String itemName, String description, int imageID, int price, String brandName, String size, String sale) {
        super(itemName, description, imageID, price);
        this.brandName = brandName;
        this.size = size;
        this.sale = sale;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
