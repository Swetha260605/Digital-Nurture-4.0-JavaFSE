public class Logger {

    private static volatile Logger instance; // volatile for thread safety

    private Logger() {
        System.out.println("Logger Initialized!");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }

    public static void main(String[] args) {
        System.out.println("--- Starting Singleton Logger Test ---");

        Logger logger1 = Logger.getInstance();
        logger1.log("First log");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log");

        if (logger1 == logger2) {
            System.out.println("Both are same, they are Singleton!");
        } else {
            System.out.println("Error: Instances are different!");
        }

        System.out.println("Logger 1 hashCode: " + logger1.hashCode());
        System.out.println("Logger 2 hashCode: " + logger2.hashCode());
    }
}