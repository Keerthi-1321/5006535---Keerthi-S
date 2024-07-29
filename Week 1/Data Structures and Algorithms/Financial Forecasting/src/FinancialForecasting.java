import java.util.Scanner;

public class FinancialForecasting {

    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years <= 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get initial value from the user
        System.out.print("Enter the initial value of the investment: ");
        double initialValue = scanner.nextDouble();

        // Get growth rate from the user
        System.out.print("Enter the annual growth rate (as a percentage, e.g., 5 for 5%): ");
        double growthRate = scanner.nextDouble() / 100; // Convert percentage to decimal

        // Get number of years from the user
        System.out.print("Enter the number of years to forecast: ");
        int years = scanner.nextInt();

        // Calculate and display future value
        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value: " + futureValue);

        scanner.close();
    }
}
