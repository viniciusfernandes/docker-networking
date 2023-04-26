package br.com.tutorial.dockernetworking.networkingmicroserviceconsumer;

import br.com.tutorial.dockernetworking.networkingmicroserviceconsumer.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers/{idCustomer}")
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable("idCustomer") String idCustomer) {
        var customer = customerRepository.findCustomerById(idCustomer);
        if (customer == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> findCustomers() {
        var customers = customerRepository.findCustomers();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }


}
