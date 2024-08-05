package finance;

public class FinancialForecasingIter {

    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double initialValue = 1000; 
        double growthRate = 0.05;
        int periods = 10; 

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value: $" + futureValue);
    }
}
