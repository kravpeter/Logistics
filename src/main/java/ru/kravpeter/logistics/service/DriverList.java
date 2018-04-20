package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kravpeter.logistics.entity.Driver;

import java.util.List;

public class DriverList {

    private List<Driver> driverList;

    public List<Driver> getDriverList() { return driverList; }
    public void setDriverList(List<Driver> driverList) { this.driverList = driverList; }
}
