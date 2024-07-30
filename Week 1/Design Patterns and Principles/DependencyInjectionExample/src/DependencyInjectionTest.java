public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Add customers to the repository
        customerService.addCustomer(new Customer("170", "Keerthi"));
        customerService.addCustomer(new Customer("472", "Pragadees"));
        customerService.addCustomer(new Customer("173", "Emma"));

        // Use the service to find customers
        Customer customer1 = customerService.getCustomerById("472");
        System.out.println(customer1);

        Customer customer2 = customerService.getCustomerById("173");
        System.out.println(customer2);

        Customer customer3 = customerService.getCustomerById("170");
        System.out.println(customer3);

        Customer customer4 = customerService.getCustomerById("444");
        System.out.println(customer4);
    }
}
