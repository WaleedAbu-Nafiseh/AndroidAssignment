package com.example.project1.model.Cars;
import com.example.project1.R;
import com.example.project1.model.abstractData.AbstractItem;

public class CarItem extends AbstractItem {
    String CarModel;
    int CarYear;

    public CarItem() {
        super();
    }
    public CarItem(String itemName, String description, int imageID, int price, String carModel, int carYear) {
        super(itemName, description, imageID, price);
       this.CarModel = carModel;
        this.CarYear = carYear;
    }


    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    public int getCarYear() {
        return CarYear;
    }

    public void setCarYear(int carYear) {
        CarYear = carYear;
    }
}
