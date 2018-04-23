package ru.kravpeter.logistics.service;

import ru.kravpeter.logistics.entity.City;

public class CargoModel {
    private City city;
    private String cargoType;
    private short cargoWeight;
    private String cargoStatus;
    public CargoModel(City city,
                      String cargoType,
                      short cargoWeight,
                      String cargoStatus){
        this.city = city;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
        this.cargoStatus = cargoStatus;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public short getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(short cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
