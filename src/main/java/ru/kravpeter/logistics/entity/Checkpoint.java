package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="checkpoints")
public class Checkpoint implements Serializable{
    private long checkpointId;
    private Trip checkpointTrip;
    private List<Cargo> checkpointCargoes;
    private City checkpointDepCity;
    private City checkpointArrCity;
    private short checkpointStatus;
    private Date checkpointActDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkpoint_id")
    public long getCheckpointId() { return checkpointId; }
    public void setCheckpointId(long checkpointId) { this.checkpointId = checkpointId; }
    @ManyToOne
    @JoinColumn(name="trip_id")
    public Trip getCheckpointTrip() { return checkpointTrip; }
    public void setCheckpointTrip(Trip checkpointTrip) { this.checkpointTrip = checkpointTrip; }
    @OneToMany
    @JoinColumn(name="cargo_id")
    public List<Cargo> getCheckpointCargoes() { return checkpointCargoes; }
    public void setCheckpointCargoes(List<Cargo> checkpointCargoes) { this.checkpointCargoes = checkpointCargoes; }
    @ManyToOne
    @JoinColumn(name="checkpoint_dep_city")
    public City getCheckpointDepCity() { return checkpointDepCity; }
    public void setCheckpointDepCity(City checkpointDepCity) { this.checkpointDepCity = checkpointDepCity; }
    @ManyToOne
    @JoinColumn(name="checkpoint_arr_city")
    public City getCheckpointArrCity() { return checkpointArrCity; }
    public void setCheckpointArrCity(City checkpointArrCity) { this.checkpointArrCity = checkpointArrCity; }
    @Column(name="checkpoint_status")
    public short getCheckpointStatus() { return checkpointStatus; }
    public void setCheckpointStatus(short checkpointStatus) { this.checkpointStatus = checkpointStatus; }
    @Temporal(TemporalType.DATE)
    @Column(name="checkpoint_act_date")
    public Date getCheckpointActDate() { return checkpointActDate; }
    public void setCheckpointActDate(Date checkpointActDate) { this.checkpointActDate = checkpointActDate; }
}
