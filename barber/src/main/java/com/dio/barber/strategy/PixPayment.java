package com.dio.barber.strategy;

import com.dio.barber.strategy.interfaces.PaymentStrategy;

public class PixPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Pix.");
    }
}
