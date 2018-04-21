package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="drivers")
public class Driver implements Serializable{
    private int driverId;
    private User driverUser;
    private int driverHours;
    private int driverStatus;
    private Truck driverTruck;
    private City driverCity;
    //private List<Trip> driverTrips;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="driver_id")
    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }
    @OneToOne
    @JoinColumn(name="driver_email")
    public User getDriverUser() { return driverUser; }
    public void setDriverUser(User driverUser) { this.driverUser = driverUser; }
    @Column(name="driver_hours")
    public int getDriverHours() { return driverHours; }
    public void setDriverHours(int driverHours) { this.driverHours = driverHours; }
    @Column(name="driver_status")
    public int getDriverStatus() { return driverStatus; }
    public void setDriverStatus(int driverStatus) { this.driverStatus = driverStatus; }
    @ManyToOne
    @JoinColumn(name="driver_current_truck", nullable = true)
    public Truck getDriverTruck() { return driverTruck; }
    public void setDriverTruck(Truck driverTruck) { this.driverTruck = driverTruck; }
    @ManyToOne
    @JoinColumn(name="driver_current_location")
    public City getDriverCity() { return driverCity; }
    public void setDriverCity(City driverCity) { this.driverCity = driverCity; }
    /*@ManyToMany
    @JoinTable(name ="driverlist",
                joinColumns = @JoinColumn(name="driver_id"),
                inverseJoinColumns = @JoinColumn(name="trip_id"))
    */

    private List<Trip> driverTrips;
    @ManyToMany( mappedBy = "tripDrivers" )
    public List<Trip> getDriverTrips() { return driverTrips; }
    public void setDriverTrips(List<Trip> driverTrips) { this.driverTrips = driverTrips; }
    @Override
    public String toString() {
        return driverUser.getUserName() + " " +
                driverUser.getUserSurname() + " email: " +
                driverUser.getEmail() + " hours: " +
                driverHours + ".\n";
    }
}
    /*public Driver(User user, City city){
        this.user = user;
        driver_city = city;
        driver_hours = 0;
        driver_status = 0; //0 - Off-work; 1 - Standby; 2 - Driving
        driver_city = city;
    }
    public String get_driver_name(){
        return user.get_user_name();
    }
    public String get_driver_surname(){
        return user.get_user_surname();
    }
    public String get_driver_status(){
        switch (driver_status){
            case 0: return "Off-work";
            case 1: return "Standby";
            case 2: return "Driving";
            default: return null;
        }
    }
    public int get_driver_hours(){
        return driver_hours;
    }
    public String get_driver_vehicle(){
        return "no";
    }
    public String get_driver_phone_number(){
        return user.get_user_phone_number();
    }
    public String get_driver_email(){
        return user.get_user_email();
    }

    public String get_driver_city() {
        return driver_city.getCityName();
    }*/
