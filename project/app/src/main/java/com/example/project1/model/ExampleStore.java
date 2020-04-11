package com.example.project1.model;

import java.util.List;

public class ExampleStore {
    int categoryImageID;
    private List<ExampleCategory> categoryList;

    public ExampleStore() {
    }

    public ExampleStore(int categoryImageID, List<ExampleCategory> categoryList) {
        this.categoryImageID = categoryImageID;
        this.categoryList = categoryList;
    }

    public int getCategoryImageID() {
        return categoryImageID;
    }

    public void setCategoryImageID(int categoryImageID) {
        this.categoryImageID = categoryImageID;
    }

    public List<ExampleCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<ExampleCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
