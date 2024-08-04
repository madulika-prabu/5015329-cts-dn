package Singleton;

public class SingletonTest {
	public static void main(String[] args) {
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		if (log1 == log2) {
			System.out.println("Both loggers are same instance.");
		}
		else {
			System.out.println("Both loggers are different instances.");
		}
		log1.log("Message 1");
		log2.log("Message 2");
	}

}
