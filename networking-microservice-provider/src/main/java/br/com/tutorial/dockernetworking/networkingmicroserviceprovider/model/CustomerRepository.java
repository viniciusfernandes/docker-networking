package br.com.tutorial.dockernetworking.networkingmicroserviceprovider.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class CustomerRepository {
    private final List<Customer> repository;

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

        repository = new ArrayList<>();
        repository.add(c1);
        repository.add(c2);
    }

    public Customer findCustomerById(String id) {
        return repository.stream().filter(c -> c.id.equals(id)).findFirst().orElse(null);
    }


    public List<Customer> findCustomers() {
        return repository;
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            return Collections.emptyList();
        }
        customers.forEach(customer -> customer.id = UUID.randomUUID().toString());
        repository.addAll(customers);
        return customers;
    }

    public boolean deleteCustomer(String idCustomer) {
        for (var i = 0; i < repository.size(); i++) {
            if (repository.get(i).id.equals(idCustomer)) {
                repository.remove(i);
                return true;
            }
        }
        return false;
    }
}
