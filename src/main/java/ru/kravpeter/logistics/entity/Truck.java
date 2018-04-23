package ru.kravpeter.logistics.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="trucks")
public class Truck implements Serializable{

    private String truckRegNumber;
    private short truckCapacity;
    private short truckQuantityOfDrivers;
    private String truckStatus;
    private Timestamp truckRegDate;
    private City city;
    private List<Driver> truckDrivers;

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

    public String getTruckStatus() { return truckStatus; }

    public void setTruckStatus(String truckStatus) { this.truckStatus = truckStatus; }

    @Column(name = "truck_reg_date")
    @Temporal(TemporalType.DATE)

    public Date getTruckRegDate() { return truckRegDate; }

    public void setTruckRegDate(Date truckRegDate) {  }

    @ManyToOne
    @JoinColumn(name="truck_current_location")

    public City getCity() { return city; }

    public void setCity(City city) { this.city = city; }

    @OneToMany(
            mappedBy = "driverTruck",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    public List<Driver> getTruckDrivers() { return truckDrivers; }
    public void setTruckDrivers(List<Driver> truckDrivers) { this.truckDrivers = truckDrivers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return truckCapacity == truck.truckCapacity &&
                truckQuantityOfDrivers == truck.truckQuantityOfDrivers &&
                Objects.equals(truckRegNumber, truck.truckRegNumber) &&
                Objects.equals(truckStatus, truck.truckStatus) &&
                Objects.equals(truckRegDate, truck.truckRegDate) &&
                Objects.equals(city, truck.city) &&
                Objects.equals(truckDrivers, truck.truckDrivers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(truckRegNumber, truckCapacity, truckQuantityOfDrivers, truckStatus, truckRegDate, city, truckDrivers);
    }
}
