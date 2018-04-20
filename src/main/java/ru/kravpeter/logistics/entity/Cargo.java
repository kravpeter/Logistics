package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cargoes")
public class Cargo implements Serializable {
    private long cargoId;
    private long checkpointId;
    private String cargoType;
    private int cargoWeight;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    public long getCargoId() { return cargoId; }
    public void setCargoId(long cargoId) { this.cargoId = cargoId; }
    @Column(name="checkpoint_id")
    public long getCheckpointId() { return checkpointId; }
    public void setCheckpointId(long checkpointId) { this.checkpointId = checkpointId; }
    @Column(name = "cargo_type")
    public String getCargoType() { return cargoType; }
    public void setCargoType(String cargoType) { this.cargoType = cargoType; }
    @Column(name = "cargo_weight")
    public int getCargoWeight() { return cargoWeight; }
    public void setCargoWeight(int cargoWeight) { this.cargoWeight = cargoWeight; }
}
