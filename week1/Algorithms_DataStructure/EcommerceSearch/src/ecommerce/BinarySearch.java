package ecommerce;
import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    public static Product binarySearch(Product[] products, String targetProductId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetProductId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Book", "Books")
        };


        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        Product result = binarySearch(products, "P002");
        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }
    }
}


