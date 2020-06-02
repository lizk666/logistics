package cn.example.utils;

import cn.example.domain.Supply;
import cn.example.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Transfer {
    /**
     * 获取车辆装货量集合
     * @param vehicle
     * @return
     */
    public static List<Double> getVehicleCapacity(List<Vehicle> vehicle){
        List<Double> vehicleCapacity = new ArrayList<>();
        for (int i = 0; i < vehicle.size(); i++) {
            vehicleCapacity.add(vehicle.get(i).getCarcapacity());
        }
        return vehicleCapacity;
    }
    public static List<Double> getCenterPosition(Supply supply){
        List<Double> centerPosition = new ArrayList<>();
        centerPosition.add(supply.getSupplylongitude());
        centerPosition.add(supply.getSupplylatitude());
        return centerPosition;

    }
}
