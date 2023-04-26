package br.com.tutorial.dockernetworking.networkingmicroserviceconsumer;

import br.com.tutorial.dockernetworking.networkingmicroserviceconsumer.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "customer", url = "http://customer-provider:8080/provider")
public interface CustomerRepository {
    @RequestMapping(method = RequestMethod.GET, value = "/customer/{idCustomer}")
    public CustomerResponse findCustomerById(@PathVariable("idCustomer") String idCustomer);
    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public List<CustomerResponse> findCustomers();
}
