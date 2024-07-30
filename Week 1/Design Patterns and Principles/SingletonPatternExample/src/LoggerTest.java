public class LoggerTest {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Singleton pattern works! Both references are the same instance.");
        } else {
            System.out.println("Singleton pattern failed! Different instances found.");
        }

        // Use the logger
        logger1.log("This is a log message.");
    }
}
