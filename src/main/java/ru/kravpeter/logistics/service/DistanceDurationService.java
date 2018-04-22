package ru.kravpeter.logistics.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import org.springframework.stereotype.Service;

@Service
public class DistanceDurationService {

    private long dist = 0, dur = 0;


    public String getDistanceDuration(String s1, String s2){
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyCQff1C2bzv8x4Zq_dk7O78rMl2R1vr7FI")
                .build();
        DirectionsResult results = DirectionsApi.getDirections(context, s1, s2).awaitIgnoreError();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        for (DirectionsLeg leg: results.routes[0].legs) {
            dist += leg.distance.inMeters;
            dur += leg.duration.inSeconds;
        }
        dist = dist/1000; dur = dur/3600;
        return "Distance — " + dist + " km.;\nDuration — " + dur +"h.";
    }

}
