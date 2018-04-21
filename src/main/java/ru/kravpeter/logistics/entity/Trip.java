package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
                cascade = CascadeType.ALL,
                orphanRemoval = true )
    public List<Checkpoint> getTripCheckpoints() { return tripCheckpoints; }
    public void setTripCheckpoints(List<Checkpoint> tripCheckpoints) { this.tripCheckpoints = tripCheckpoints; }
    @ManyToMany(
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "driverlist",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id")
    )
    public List<Driver> getTripDrivers() { return tripDrivers; }
    public void setTripDrivers(List<Driver> tripDrivers) { this.tripDrivers = tripDrivers; }




}
