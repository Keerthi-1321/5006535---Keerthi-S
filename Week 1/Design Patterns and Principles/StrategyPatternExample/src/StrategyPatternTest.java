public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // pay using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1704-5678-9012-3456", "Keerthi", "507");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(550.00);

        // pay using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("keerthi@gmail.com", "Keerthi123");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(150.00);
    }
}
