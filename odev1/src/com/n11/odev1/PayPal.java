package com.n11.odev1;

public class PayPal implements IPay{
    @Override
    public void pay(String value) {
        System.out.println(value + " PayPal ile ödendi!");
    }
}
