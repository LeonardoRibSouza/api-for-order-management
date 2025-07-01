package br.com.leonardo.controller;

import br.com.leonardo.data.dto.CustomerDTO;
import br.com.leonardo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public List<CustomerDTO> findAll(){
        return customerService.findAll();
    }

    //cadastrar novo cliente
    @PostMapping(value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerDTO register(@RequestBody CustomerDTO customer){
        return customerService.register(customer);
    }

    //atualizar cliente já cadastrado
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerDTO updateClient(@RequestBody CustomerDTO customer){
        return customerService.updateClient(customer);
    }

    //deletar cliente cadastrado
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        customerService.delete(id);
    }


}
