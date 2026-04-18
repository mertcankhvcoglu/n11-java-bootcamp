package com.n11.odev1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplePay applePay = new ApplePay();
        CreditCard creditCard = new CreditCard();
        PayPal payPal = new PayPal();

        PaymentService paymentService = new PaymentService(creditCard);
        paymentService.pay("300 TL");

        PaymentService paymentService2 = new PaymentService(applePay);
        paymentService2.pay("29.52 $");

        PaymentService paymentService3 = new PaymentService(payPal);
        paymentService3.pay("42.57 €");
    }
}