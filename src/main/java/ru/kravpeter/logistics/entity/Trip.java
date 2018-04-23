package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="trips")
public class Trip implements Serializable{
    private long tripId;
    private User tripManager;
    private String tripStatus;
    private Truck tripTruck;
    private Date tripStartDate;
    //private Date tripEndDate;
    private List<Checkpoint> tripCheckpoints;
    private List<Driver> tripDrivers;
    /*public Trip(User tripManager,
                Truck tripTruck,
                List<Checkpoint> tripCheckpoints,
                List<Driver> tripDrivers){
        this.tripManager = tripManager;
        this.tripTruck = tripTruck;
        this.tripCheckpoints = tripCheckpoints;
        this.tripDrivers = tripDrivers;
        tripStatus = "in progress";
    }*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trip_id")
    public long getTripId() { return tripId; }
    public void setTripId(long tripId) { this.tripId = tripId; }
    @ManyToOne
    @JoinColumn(name="trip_manager")
    public User getTripManager() { return tripManager; }
    public void setTripManager(User tripManager) { this.tripManager = tripManager; }
    @Column(name= "trip_status")
    public String getTripStatus() { return tripStatus; }
    public void setTripStatus(String tripStatus) { this.tripStatus = tripStatus; }
    @ManyToOne
    @JoinColumn(name="truck_reg_number")
    public Truck getTripTruck() { return tripTruck; }
    public void setTripTruck(Truck tripTruck) { this.tripTruck = tripTruck; }
    @Column(name = "trip_start_date")
    @Temporal(TemporalType.DATE)
    public Date getTripStartDate() { return tripStartDate; }
    public void setTripStartDate(Date tripStartDate) { this.tripStartDate = tripStartDate; }
    //@Column(name = "trip_end_date")
    //@Temporal(TemporalType.DATE)
    //public Date getTripEndDate() { return tripEndDate; }
    //public void setTripEndDate(Date tripEndDate) { this.tripEndDate = tripEndDate; }
    @OneToMany( fetch = FetchType.EAGER,
                mappedBy = "checkpointTrip",
                cascade = CascadeType.ALL )
    public List<Checkpoint> getTripCheckpoints() { return tripCheckpoints; }
    public void setTripCheckpoints(List<Checkpoint> tripCheckpoints) { this.tripCheckpoints = tripCheckpoints; }
    @OneToMany(//fetch = FetchType.EAGER,
                mappedBy = "driverTrip",
                cascade = CascadeType.ALL)
    public List<Driver> getTripDrivers(){return this.tripDrivers;}
    public void setTripDrivers(List<Driver> tripDrivers) { this.tripDrivers = tripDrivers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return tripId == trip.tripId &&
                Objects.equals(tripManager, trip.tripManager) &&
                Objects.equals(tripStatus, trip.tripStatus) &&
                Objects.equals(tripTruck, trip.tripTruck) &&
                Objects.equals(tripStartDate, trip.tripStartDate) &&
                Objects.equals(tripCheckpoints, trip.tripCheckpoints) &&
                Objects.equals(tripDrivers, trip.tripDrivers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tripId, tripManager, tripStatus, tripTruck, tripStartDate, tripCheckpoints, tripDrivers);
    }
}
