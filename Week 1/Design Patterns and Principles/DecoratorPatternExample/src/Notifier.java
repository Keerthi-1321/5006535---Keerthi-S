public interface Notifier {
    void send(String message);
}

// EmailNotifier.java (Concrete Component)
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// NotifierDecorator.java (Abstract Decorator)
abstract class NotifierDecorator implements Notifier {
    protected Notifier decoratedNotifier;

    public NotifierDecorator(Notifier decoratedNotifier) {
        this.decoratedNotifier = decoratedNotifier;
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
    }
}

// SMSNotifierDecorator.java (Concrete Decorator)
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// SlackNotifierDecorator.java (Concrete Decorator)
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}
