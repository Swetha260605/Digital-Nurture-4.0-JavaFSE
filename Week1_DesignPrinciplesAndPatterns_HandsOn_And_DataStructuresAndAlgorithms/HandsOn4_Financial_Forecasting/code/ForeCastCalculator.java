package code;

public class ForeCastCalculator {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 10000;
        double annualGrowthRate = 0.10; 
        int forecastYears = 5;

        double futureValue = predictFutureValue(initialValue, annualGrowthRate, forecastYears);
        System.out.printf("Future Value after %d years: %.2f\n", forecastYears, futureValue);
    }
}
