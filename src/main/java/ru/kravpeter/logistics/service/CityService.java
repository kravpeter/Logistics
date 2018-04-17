package ru.kravpeter.logistics.service;

import ru.kravpeter.logistics.entity.City;
import ru.kravpeter.logistics.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Transactional
    public List<City> getCities(){ return cityRepository.findAll();}

    @Transactional
    public City addCity(String cityName){
        City city = new City();
        city.setCityName(cityName);
        cityRepository.saveAndFlush(city);
        return city;
    }


}
