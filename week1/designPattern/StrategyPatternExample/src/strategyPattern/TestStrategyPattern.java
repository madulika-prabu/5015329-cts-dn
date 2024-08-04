package strategyPattern;

public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentStrategy payment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        payment.pay(100.00);
        CreditCardPayment creditCardPayment = (CreditCardPayment) payment;
        System.out.println("Current Card Number: " + creditCardPayment.getCardNumber());
        creditCardPayment.setCardNumber("5678-1234-4321-8765");
        System.out.println("Updated Card Number: " + creditCardPayment.getCardNumber());
        System.out.println("Current Card Holder Name: " + creditCardPayment.getCardHolderName());
        creditCardPayment.setCardHolderName("Jane Doe");
        System.out.println("Updated Card Holder Name: " + creditCardPayment.getCardHolderName());
    }
}

