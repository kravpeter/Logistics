package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kravpeter.logistics.entity.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverList {

    private ArrayList<Driver> driverList;

    public ArrayList<Driver> getDriverList() { return driverList; }
    public void setDriverList(ArrayList<Driver> driverList) { this.driverList = driverList; }
}
