public interface CustomerRepository {
    Customer findCustomerById(String id);
    void addCustomer(Customer customer);
}
