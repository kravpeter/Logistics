package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="cargoes")
public class Cargo implements Serializable {
    private long cargoId;
    private Checkpoint cargoCheckpoint;
    private String cargoType;
    private int cargoWeight;
    private String cargoStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    public long getCargoId() { return cargoId; }
    public void setCargoId(long cargoId) { this.cargoId = cargoId; }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="checkpoint_id")
    public Checkpoint getCargoCheckpoint() { return cargoCheckpoint; }
    public void setCargoCheckpoint(Checkpoint cargoCheckpoint) { this.cargoCheckpoint = cargoCheckpoint; }
    @Column(name = "cargo_type")
    public String getCargoType() { return cargoType; }
    public void setCargoType(String cargoType) { this.cargoType = cargoType; }
    @Column(name = "cargo_weight")
    public int getCargoWeight() { return cargoWeight; }
    public void setCargoWeight(int cargoWeight) { this.cargoWeight = cargoWeight; }
    @Column(name = "cargo_status")
    public String getCargoStatus() { return cargoStatus; }
    public void setCargoStatus(String cargoStatus) { this.cargoStatus = cargoStatus; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return cargoId == cargo.cargoId &&
                cargoWeight == cargo.cargoWeight &&
                Objects.equals(cargoCheckpoint, cargo.cargoCheckpoint) &&
                Objects.equals(cargoType, cargo.cargoType) &&
                Objects.equals(cargoStatus, cargo.cargoStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cargoId, cargoCheckpoint, cargoType, cargoWeight, cargoStatus);
    }
}
