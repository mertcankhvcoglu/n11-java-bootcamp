package com.n11.odev1;

public class ApplePay implements IPay {
    @Override
    public void pay(String value) {
        System.out.println(value + " Apple Pay ile ödendi!");
    }
}