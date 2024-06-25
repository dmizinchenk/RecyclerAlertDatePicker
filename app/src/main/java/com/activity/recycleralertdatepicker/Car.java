package com.activity.recycleralertdatepicker;

public class Car {
    private String brand;
    private String model;
    int photo;

    public Car(String brand, String model, int photo) {
        this.brand = brand;
        this.model = model;
        this.photo = photo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
