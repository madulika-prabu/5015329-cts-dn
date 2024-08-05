package Sort;

public class BubbleSort {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
       
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 150.75),
            new Order("O002", "Bob", 99.99),
            new Order("O003", "Charlie", 200.00),
            new Order("O004", "David", 50.50)
        };

        bubbleSort(orders);

        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

