import java.util.Scanner;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the message
        System.out.print("Enter the message to send: ");
        String message = scanner.nextLine();

        // Create a basic Email Notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate Email Notifier with SMS functionality
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate Email Notifier with Slack functionality
        Notifier slackSMSNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Send message using all decorators
        slackSMSNotifier.send(message);

        // Close the scanner
        scanner.close();
    }
}
