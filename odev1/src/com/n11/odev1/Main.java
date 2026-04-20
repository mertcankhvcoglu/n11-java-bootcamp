package com.n11.odev1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        ApplePay applePay = new ApplePay();
//        CreditCard creditCard = new CreditCard();
//        PayPal payPal = new PayPal();
//
//        PaymentService paymentService = new PaymentService(creditCard);
//        paymentService.pay("300 TL");
//
//        PaymentService paymentService2 = new PaymentService(applePay);
//        paymentService2.pay("29.52 $");
//
//        PaymentService paymentService3 = new PaymentService(payPal);
//        paymentService3.pay("42.57 €");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ödeme yöntemini giriniz (ApplePay, PayPal, CreditCard):");
        String sinifAdi = scanner.nextLine(); // sinifAdi->PayPal girildi

        System.out.println("Ödeme yapmak istediğiniz tutarı giriniz (Örn: 500 TL, 50 $)");
        String miktar = scanner.nextLine(); // miktar-> 500 TL girildi

        try
        {
            String tamYol = "com.n11.odev1." + sinifAdi; // tamyol-> com.n11.odev1.PayPal
            Class<?> c = Class.forName(tamYol); // sınıfı runtime'da metadaya atma işi

            // reflection kısmı,
            IPay secilenOdemeYontemi = (IPay) c.getDeclaredConstructor().newInstance(); //secilenOdemeYontemi-> oluşturulan objenin referans değerini tutan değişken
            // yz bilgisi : Eskiden doğrudan .newInstance() kullanılırdı ama o yöntem bazı hataları
            // gizlediği için artık "Önce constructor'ı bul, sonra oradan üret" mantığı (Modern Java) tercih ediliyor.

            PaymentService paymentService = new PaymentService(secilenOdemeYontemi);
            paymentService.pay(miktar);

        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Girilen ödeme yöntemi hatalı!");
        }
        catch (Exception e)
        {
            System.err.println("Beklenmedik bir hata oluştu" + e.getMessage());
        }
        finally
        {
            scanner.close();
        }
    }
}