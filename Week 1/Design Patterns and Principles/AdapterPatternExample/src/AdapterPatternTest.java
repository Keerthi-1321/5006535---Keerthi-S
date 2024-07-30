public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create gateway instances
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Create adapters for the payment gateways
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Process payments through the adapters
        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(250.00);
    }
}

