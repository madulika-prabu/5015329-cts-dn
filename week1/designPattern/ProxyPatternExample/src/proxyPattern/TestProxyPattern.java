package proxyPattern;

public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("First call to display photo1.jpg:");
        image1.display();

        System.out.println("\nSecond call to display photo1.jpg:");
        image1.display();

        System.out.println("\nFirst call to display photo2.jpg:");
        image2.display();
    }
}