package dependencyInjection;

public interface CustomerRepository {
    Customer findCustomerById(String customerId);
}
