package org.example.jdk.demo.finalclass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/6/3
 */
public class CarLocationTracker {

    private Map<String, Location> locationMap = new ConcurrentHashMap<>();


    public void updateLocation(String carCode, double x, double y) {
        locationMap.put(carCode, new Location(x, y));
    }

    public Location getLocation(String carCode) {
        return locationMap.get(carCode);
    }

}
