package ru.kravpeter.logistics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
    @Id
    @Column(name="city_id")
    private int cityId;
    @Column(name="city_name")
    private String cityName;
    protected City(){}
    public City(String cityName){this.cityName = cityName;}
    //@OneToMany (mappedBy = "city")
    //private List<Truck> listTucks;
    //public List<Truck> getTrucks(){
    //    return listTucks;
    //}

    public int getCityId() { return cityId; }

    public void setCityId(int cityId) { this.cityId = cityId; }

    public String getCityName() { return cityName; }

    public void setCityName(String cityName) { this.cityName = cityName; }

    public String toString(){
        return cityName;
    }

}
