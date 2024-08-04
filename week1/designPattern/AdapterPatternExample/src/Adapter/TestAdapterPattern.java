package Adapter;

public class TestAdapterPattern {
    public static void main(String[] args) {
    	
    	Gpay gpay = new Gpay();
        PaymentProcessor gpayProcessor = new GpayAdapter(gpay);
        gpayProcessor.processPayment(800.00);
        
        PhonePay phonePay = new PhonePay();
        PaymentProcessor phonePayProcessor = new PhonePayAdapter(phonePay);
        phonePayProcessor.processPayment(650.00);
        
        PayPal payPal = new PayPal();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        payPalProcessor.processPayment(750.00);
        
    }
}
