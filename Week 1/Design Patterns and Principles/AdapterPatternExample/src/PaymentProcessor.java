public interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void payWithPayPal(double amount) {
        System.out.println("Processing payment of Rs " + amount + " with PayPal.");
    }
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of Rs " + amount + " with Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.payWithPayPal(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makePayment(amount);
    }
}

