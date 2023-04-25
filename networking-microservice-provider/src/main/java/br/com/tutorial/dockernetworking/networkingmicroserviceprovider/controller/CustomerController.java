package br.com.tutorial.dockernetworking.networkingmicroserviceprovider.controller;

import br.com.tutorial.dockernetworking.networkingmicroserviceprovider.model.Customer;
import br.com.tutorial.dockernetworking.networkingmicroserviceprovider.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers/{idCustomer}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("idCustomer") String idCustomer) {
        var customer = customerRepository.findCustomerById(idCustomer);
        if (customer == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findCustomers() {
        var customers = customerRepository.findCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/customers")
    public ResponseEntity<List<Customer>> saveCustomers(@RequestBody List<Customer> customers) {
        if (customers.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerRepository.saveCustomers(customers));
    }


    @DeleteMapping("/customers/{idCustomer}")
    public ResponseEntity<Void> saveCustomers(@PathVariable String idCustomer) {
        if (idCustomer == null || idCustomer.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        var deleted = customerRepository.deleteCustomer(idCustomer);
        return deleted ? ResponseEntity.accepted().build() : ResponseEntity.noContent().build();
    }
}
