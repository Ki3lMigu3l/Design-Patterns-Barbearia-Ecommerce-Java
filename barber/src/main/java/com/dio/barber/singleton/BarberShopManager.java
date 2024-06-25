package com.dio.barber.singleton;

import java.util.ArrayList;
import java.util.List;

public class BarberShopManager {
    private static BarberShopManager instance;
    private List<String> services;

    private BarberShopManager() {
        services = new ArrayList<>();
    }

    public static BarberShopManager getInstance(){
        if (instance == null) {
            instance = new BarberShopManager();
        }
        return instance;
    }

    public void addService(String service) {
        services.add(service);
    }

    public List<String> getServices() {
        return services;
    }
}
