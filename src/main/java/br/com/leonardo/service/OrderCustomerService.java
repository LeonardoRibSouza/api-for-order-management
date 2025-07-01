package br.com.leonardo.service;

import br.com.leonardo.data.dto.OrderCustomerDTO;
import static br.com.leonardo.mapper.ObjectMapper.parseObject;
import static br.com.leonardo.mapper.ObjectMapper.parseListObjects;

import br.com.leonardo.exception.ResourceNotFoundException;
import br.com.leonardo.model.ItemOrdered;
import br.com.leonardo.model.OrderCustomer;
import br.com.leonardo.repository.RepositoryOrderCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Service
public class OrderCustomerService {

    @Autowired
    private RepositoryOrderCustomer repository;

    private static final Logger log = Logger.getLogger(OrderCustomerService.class.getName());



    //cadastrar novo pedido
    public OrderCustomerDTO create(@RequestBody OrderCustomerDTO orderCustomerDTO) {
        log.info("registering order");
        var entity = parseObject(calculateTotal(orderCustomerDTO), OrderCustomer.class);

        return parseObject(repository.save(entity),OrderCustomerDTO.class);
    }

    public OrderCustomerDTO calculateTotal(OrderCustomerDTO orderCustomerDTO) {
        BigDecimal totalGeral = BigDecimal.ZERO;

        for ( ItemOrdered item : orderCustomerDTO.getItems()) {
            BigDecimal totalItem = item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            item.setTotal(totalItem);
        }
        for(ItemOrdered item : orderCustomerDTO.getItems()) {
            totalGeral = totalGeral.add(item.getTotal());
        }

        orderCustomerDTO.setTotal(totalGeral);
        return orderCustomerDTO;
    }

    //retorna todos os pedidos
    public List<OrderCustomerDTO> findAll() {
        log.info("finding all orders");

        return parseListObjects(repository.findAll(),OrderCustomerDTO.class);

    }

    //fazer busca por id
    public OrderCustomerDTO findById(Long id) {
        log.info("finding order customer by id: " + id);
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Order customer with id: " + id + " not found");
        }
        return parseObject(repository.findById(id),OrderCustomerDTO.class);
    }

    //atualiza toda a entidade
    public OrderCustomerDTO updateAll(OrderCustomerDTO orderCustomerDTO) {
        log.info("updating order customer by id: " + orderCustomerDTO.getId());

        var entity = repository.findById(orderCustomerDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Order customer with id: " + orderCustomerDTO.getId() + " not found"));

        entity.setCustomerId(orderCustomerDTO.getCustomerId());
        entity.setItems(orderCustomerDTO.getItems());
        entity.setTotal(orderCustomerDTO.getTotal());
        entity.setStatus(orderCustomerDTO.getStatus());

        return parseObject(entity,OrderCustomerDTO.class);

    }

    //deleta id do banco de dados
    public void delete(Long id) {
        log.info("deleting order customer by id: " + id);
        repository.deleteById(id);
    }

}
