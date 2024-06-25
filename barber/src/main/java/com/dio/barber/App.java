package com.dio.barber;

import com.dio.barber.facade.BarberShopFacade;
import com.dio.barber.strategy.CashPayment;
import com.dio.barber.strategy.CreditCardPayment;
import com.dio.barber.strategy.PixPayment;
import com.dio.barber.strategy.interfaces.PaymentStrategy;

public class App {
    public static void main(String[] args) {
        BarberShopFacade barberShop = new BarberShopFacade();

        barberShop.addService("Social");
        barberShop.addService("Degrade");
        barberShop.addService("Taper fade");

        barberShop.showService();

        PaymentStrategy credit = new CreditCardPayment();
        barberShop.makePayment(25.0, credit);

        PixPayment pix = new PixPayment();
        barberShop.makePayment(15.0, pix);

        PaymentStrategy cash = new CashPayment();
        barberShop.makePayment(10.0, cash);
    }
}