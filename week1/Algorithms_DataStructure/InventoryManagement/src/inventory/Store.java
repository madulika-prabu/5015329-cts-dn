//Inventory management System
package inventory;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<String, Product> inventory;

    public Store() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    @Override
    public String toString() {
        return "InventoryManagementSystem{" +
                "inventory=" + inventory +
                '}';
    }

    public static void main(String[] args) {
        Store ims = new Store();

        Product product1 = new Product("P001", "Laptop", 10, 999.99);
        Product product2 = new Product("P002", "Smartphone", 20, 599.99);
        ims.addProduct(product1);
        ims.addProduct(product2);

        product1.setPrice(949.99);
        ims.updateProduct(product1);

        ims.deleteProduct("P002");

        System.out.println(ims.getProduct("P001"));

        System.out.println(ims);
    }
}
