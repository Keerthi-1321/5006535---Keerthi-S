public class Logger {
    // Step 2a: Create a private static instance of the class
    private static Logger instance;

    // Step 2b: Make the constructor private so it cannot be instantiated from outside
    private Logger() {
        // Optional initialization code can go here
        System.out.println("Logger initialized.");
    }

    // Step 2c: Provide a public static method to get the instance of the class
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
