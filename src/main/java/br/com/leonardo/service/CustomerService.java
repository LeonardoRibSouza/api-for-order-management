package br.com.leonardo.service;

import br.com.leonardo.data.dto.CustomerDTO;
import br.com.leonardo.exception.BusinessException;
import br.com.leonardo.exception.ResourceNotFoundException;
import br.com.leonardo.model.Customer;
import br.com.leonardo.repository.RepositoryCustumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Logger;
import static br.com.leonardo.mapper.ObjectMapper.parseObject;
import static br.com.leonardo.mapper.ObjectMapper.parseListObjects;
import static br.com.leonardo.validator.CpfValidator.checkCpf;

@Service
public class CustomerService {

    @Autowired
    private RepositoryCustumer repository;

    private Logger log = Logger.getLogger(CustomerService.class.getName());

    //cadastrar novo cliente
    public CustomerDTO register(@RequestBody CustomerDTO customer){
        log.info("Registrando customer");

        if (!checkCpf(customer.getCpf())){
            throw new BusinessException("invalid CPF !!!");
        };

        if(repository.existsByCpf((customer.getCpf()))){
            throw new BusinessException("There is already a user registered with this CPF");
        }

        var entity = parseObject(customer, Customer.class);
        return parseObject(repository.save(entity), CustomerDTO.class);
    }

    //listar todos os clientes cadastrados
    public List<CustomerDTO> findAll() {
        log.info("Finding all customers");
        return parseListObjects(repository.findAll(), CustomerDTO.class);
    }

    //atualizar cliente já cadastrado
    public CustomerDTO updateClient(@RequestBody CustomerDTO customer) {
        log.info("Updating customer");
        var entity = repository.findById(customer.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found with id"));

        entity.setName(customer.getName());
        entity.setCpf(customer.getCpf());
        entity.setTelephone(customer.getTelephone());
        entity.setAddress(customer.getAddress());

        return parseObject(repository.save(entity), CustomerDTO.class);

    }
    //deletar cliente cadastrado
    public void delete(Long id) {
        log.info("Deleting customer");
        Customer customer = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found with id"));

        repository.delete(customer);
    }

}
