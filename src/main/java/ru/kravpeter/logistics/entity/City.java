package ru.kravpeter.logistics.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="cities")
public class City implements Serializable{

    private int cityId;
    private String cityName;
    //protected City(){}
    //public City(String cityName){this.cityName = cityName;}
    //@OneToMany (mappedBy = "city")
    //private List<Truck> listTucks;
    //public List<Truck> getTrucks(){
    //    return listTucks;
    //}
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="city_id")
    public int getCityId() { return cityId; }
    public void setCityId(int cityId) { this.cityId = cityId; }
    @Column(name="city_name")
    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId &&
                Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityId, cityName);
    }
    //public String toString(){
    //    return cityName;
    //}

}
