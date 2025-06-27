package br.com.leonardo.teste.service;

import br.com.leonardo.teste.exception.ResourceNotFoundException;
import br.com.leonardo.teste.model.Customer;
import br.com.leonardo.teste.repository.RepositoryCustumer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerService {

    @Autowired
    private RepositoryCustumer repository;

    private Logger log = Logger.getLogger(CustomerService.class.getName());

    public Customer register(@RequestBody Customer customer){
        log.info("Registrando customer");
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        log.info("Finding all customers");
        List<Customer> customers = new ArrayList<>();
        return repository.findAll();
    }

    public Customer updateClient(@RequestBody Customer customer) {
        log.info("Updating customer");
        Customer newCustomer = repository.findById(customer.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found with id"));

        newCustomer.setName(customer.getName());
        newCustomer.setCpf(customer.getCpf());
        newCustomer.setTelephone(customer.getTelephone());
        newCustomer.setAddress(customer.getAddress());

        return repository.save(newCustomer);

    }

    public void delete(Long id) {
        log.info("Deleting customer");
        Customer customer = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found with id"));
        repository.delete(customer);
    }

    public Customer findCustomerByCpf(String numeroCpf) {
        log.info("Finding customer by cpf");
        List<Customer> customers = repository.findAll();
        Customer entity = null;
        for (Customer customer : customers) {
            if (customer.getCpf().equals(numeroCpf)) {
                entity = customer;
            }else{
                entity = null;
            }
        }
        if(entity != null){
            return entity;
        }else {
            throw new ResourceNotFoundException("No record found with cpf: " + numeroCpf);
        }
    }
}
