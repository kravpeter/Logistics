package ru.kravpeter.logistics.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="checkpoints")
public class Checkpoint implements Serializable{
}
