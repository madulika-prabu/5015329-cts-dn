package dependencyInjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String customerId) {
        return new Customer(customerId, "Madulika");
    }
}
