package br.com.leonardo.teste.controller;

import br.com.leonardo.teste.model.Customer;
import br.com.leonardo.teste.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //listar todos os clientes cadastrados
    @GetMapping(value = "/findall",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    //cadastrar novo cliente
    @PostMapping(value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer register(@RequestBody Customer customer){
        return customerService.register(customer);
    }

    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer updateClient(@RequestBody Customer customer){
        return customerService.updateClient(customer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        customerService.delete(id);
    }

    @GetMapping(value = "/cpf/{numeroCpf}",
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public Customer findCustomerByCpf(@PathVariable("numeroCpf") String numeroCpf){
        return customerService.findCustomerByCpf(numeroCpf);
    }

}
