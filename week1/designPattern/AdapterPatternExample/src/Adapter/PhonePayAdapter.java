package Adapter;

public class PhonePayAdapter implements PaymentProcessor {
    private PhonePay phonePay;

    public PhonePayAdapter(PhonePay phonePay) {
        this.phonePay = phonePay;
    }

    @Override
    public void processPayment(double amount) {
        phonePay.makePayment(amount);
    }
}
