import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, Customer> customerDatabase = new HashMap<>();

    @Override
    public Customer findCustomerById(String id) {
        return customerDatabase.get(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDatabase.put(customer.getId(), customer);
    }
}
