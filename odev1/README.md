# 18 Nisan 2026 | 1. Ödev: Yeni Ödeme Yöntemi Entegrasyonu (SOLID Prensipleri ile)

## Uygulanan Yazılım Prensipleri

### Open / Closed Principle
Sisteme `PayPal` veya `ApplePay` gibi yeni yöntemler eklenirken `PaymentService` sınıfında hiçbir değişiklik yapılmamıştır. Yeni yöntemler `IPay` arayüzünü implement eden bağımsız sınıflar olarak sisteme dahil edilmiştir.

### 2. Single Responsibility Principle (SRP)
- `IPay`: Sadece ödeme yöntemlerinin ortak imzasını taşır.
- `PaymentService`: Sadece ödeme sürecini koordine eder; hangi yöntemin nasıl çalıştığını bilmez.
- `CreditCard`, `PayPal` vb.: Sadece kendi ödeme mantıklarını yönetirler.

### 3. Dependency Inversion Principle (DIP)
`PaymentService` sınıfı somut sınıflara değil, soyut bir yapı olan `IPay` arayüzüne bağımlıdır.

`Main.java` sınıfı içerisindeki `main` metodu çalıştırılarak farklı ödeme yöntemlerinin sistemde nasıl sorunsuz çalıştığı konsol üzerinden gözlemlenebilir.

## Revizyon (20.04.2026)

Ödevin ilk aşamasında main classta statik olarak yönetilen ödeme yöntemleri, `Reflection` ile statik bir yapıya dönüştürüldü.  
Sisteme yeni bir ödeme yöntemi sınıfı eklenmesi halinde (örn: `GooglePay`), kodda değişiklik yapmaya gerek yoktur.
