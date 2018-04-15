package ru.kravpeter.logistics.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="trucks")
public class Truck {

    private String truckRegNumber;
    private short truckCapacity;
    private short truckQuantityOfDrivers;
    private boolean truckInOrder;
    private Timestamp truckRegDate;
    private City city;

    @Id
    @Column(name = "truck_reg_number")

    public String getTruckRegNumber() { return truckRegNumber; }

    public void setTruckRegNumber(String truckRegNumber) { this.truckRegNumber = truckRegNumber; }

    @Column(name = "truck_capacity")

    public short getTruckCapacity() { return truckCapacity; }

    public void setTruckCapacity(short truckCapacity) { this.truckCapacity = truckCapacity; }

    @Column (name = "truck_quantity_of_drivers")

    public short getTruckQuantityOfDrivers() { return truckQuantityOfDrivers; }

    public void setTruckQuantityOfDrivers(short truckQuantityOfDrivers) { this.truckQuantityOfDrivers = truckQuantityOfDrivers; }

    @Column(name = "truck_in_order")

    public boolean isTruckInOrder() { return truckInOrder; }

    public void setTruckInOrder(boolean truckInOrder) { this.truckInOrder = truckInOrder; }

    @Column(name = "truck_reg_date")
    @Temporal(TemporalType.DATE)

    public Date getTruckRegDate() { return truckRegDate; }

    public void setTruckRegDate(Date truckRegDate) {  }

    @ManyToOne
    @JoinColumn(name="truck_current_location")

    public City getCity() { return city; }

    public void setCity(City city) { this.city = city; }

}
