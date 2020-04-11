package com.example.project1.model;

import com.example.project1.model.abstractData.AbstractItem;

import java.util.List;

public class ExampleCategory {
    int categoryImageID;
    private List<AbstractItem> abstractItemList;

    public ExampleCategory() {
    }

    public ExampleCategory(int categoryImageID, List<AbstractItem> abstractItemList) {
        this.categoryImageID = categoryImageID;
        this.abstractItemList = abstractItemList;
    }

    public int getCategoryImageID() {
        return categoryImageID;
    }

    public void setCategoryImageID(int categoryImageID) {
        this.categoryImageID = categoryImageID;
    }

    public List<AbstractItem> getAbstractItemList() {
        return abstractItemList;
    }

    public void setAbstractItemList(List<AbstractItem> abstractItemList) {
        this.abstractItemList = abstractItemList;
    }
}
