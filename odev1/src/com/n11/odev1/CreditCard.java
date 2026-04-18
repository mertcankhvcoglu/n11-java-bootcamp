package com.n11.odev1;

public class CreditCard implements IPay {
    @Override
    public void pay(String value) {
        System.out.println(value + " Kredi kartı ile ödendi!");
    }
}
