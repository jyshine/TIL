package com.example.springcloudsleuthzipkinclient.controlelr;

import com.example.springcloudsleuthzipkinclient.entity.Customer;
import com.example.springcloudsleuthzipkinclient.repository.CustomerRepository;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CustomerController {
    RestTemplate restTemplate;
    private final CustomerRepository repository;

    public CustomerController(RestTemplate restTemplate, CustomerRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @DeleteMapping("/deleteCustomer")
    public String deleteCustomer(){
        repository.deleteAll();
        return "OK";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(){
        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        return "OK";
    }

    @GetMapping("/findAllCustomer")
    public List<Customer> findAllCustomer() throws Exception {
        List<Customer> all = repository.findAll();
        if (all.size() == 0) {
            throw new Exception("등록된 사용자가 없습니다.");
        }
        return all;
    }

    @GetMapping("/saveAndDeleteAndFind")
    public List<Customer> saveAndDeleteAndFind() throws Exception {
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));
        repository.findAll();
        repository.deleteAll();
        List<Customer> all = repository.findAll();
        if (all.size() == 0) {
            throw new Exception("등록된 사용자가 없습니다.");
        }
        return all;
    }

    @GetMapping("/findAllByFlask")
    public String findAllByFlask() {
        String format = String.format("http://127.0.0.1:5001/findAllCustomer");
        ResponseEntity<String> exchange = restTemplate.exchange(format, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });
        return exchange.getBody();
    }
}
