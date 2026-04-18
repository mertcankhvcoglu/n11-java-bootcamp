package com.n11.odev1;

public class PaymentService {
    private IPay pay;

    public PaymentService(IPay pay) {
        this.pay = pay;
    }
    public void pay(String value){
        this.pay.pay(value);
    }
}