package strategyPattern;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = validateCardNumber(cardNumber);
        this.cardHolderName = validateCardHolderName(cardHolderName);
    }

    private String validateCardNumber(String cardNumber) {

        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null or empty");
        }
        System.out.println("Validating card number: " + cardNumber);
        return cardNumber;
    }

    private String validateCardHolderName(String cardHolderName) {

        if (cardHolderName == null || cardHolderName.isEmpty()) {
            throw new IllegalArgumentException("Card holder name cannot be null or empty");
        }
        System.out.println("Validating card holder name: " + cardHolderName);
        return cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card.");
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = validateCardNumber(cardNumber);
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = validateCardHolderName(cardHolderName);
    }
}
