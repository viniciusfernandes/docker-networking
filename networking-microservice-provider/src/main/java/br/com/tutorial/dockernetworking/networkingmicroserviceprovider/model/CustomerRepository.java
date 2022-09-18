package br.com.tutorial.dockernetworking.networkingmicroserviceprovider.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private final List<Customer> customers;

    public CustomerRepository() {
        var c1 = new Customer();
        c1.age = 43;
        c1.id = "123";
        c1.email = "vinicius@hotmail.com";
        c1.name = "Vinicius Fernandes";

        var c2 = new Customer();
        c2.age = 21;
        c2.id = "444";
        c2.email = "marcos@hotmail.com";
        c2.name = "Marcos Augustus";

        customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);
    }

    public Customer findCustomerById(String id) {
        return customers.stream().filter(c -> c.id.equals(id)).findFirst().orElse(null);
    }

    public List<Customer> findCustomers() {
        return customers;
    }
}
