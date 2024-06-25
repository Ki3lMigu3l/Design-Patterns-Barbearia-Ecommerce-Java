package com.dio.barber.facade;

import com.dio.barber.singleton.BarberShopManager;
import com.dio.barber.strategy.interfaces.PaymentStrategy;

public class BarberShopFacade {
    private BarberShopManager manager;
    public BarberShopFacade () {
        this.manager = BarberShopManager.getInstance();
    }

    public void addService(String service) {
        manager.addService(service);
        System.out.println("Service added: " + service);
    }

    public void showService () {
        System.out.println("Available services");
        for (String service : manager.getServices()){
            System.out.println("- " + service);
        }
    }

    public void makePayment (double amount, PaymentStrategy strategy) {
        strategy.pay(amount);
    }
}
