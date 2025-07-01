package br.com.leonardo.controller;

import br.com.leonardo.data.dto.OrderCustomerDTO;
import br.com.leonardo.service.OrderCustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderCustomerController {

    @Autowired
    private OrderCustomerService orderCustomerService;

    //chama o service para fazer a busca
    @GetMapping(value = "/findall",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<OrderCustomerDTO> findAll() {
        return orderCustomerService.findAll();
    }

    //envia o id para o service realizar a busca
    @GetMapping(value = "/find/{id}",
        produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public OrderCustomerDTO findById(@PathVariable("id") Long id) {
        return orderCustomerService.findById(id);
    }

    //envia os dados paro o service fazer o registro
    @PostMapping(value = "/register",
        consumes =  MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderCustomerDTO register(@RequestBody @Valid OrderCustomerDTO orderCustomerDTO) {
        return orderCustomerService.create(orderCustomerDTO);
    }

    //envia os dados para o service atualizar
    @PutMapping(value = "/updateall",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderCustomerDTO updateAll(@RequestBody @Valid OrderCustomerDTO orderCustomerDTO) {
        return orderCustomerService.updateAll(orderCustomerDTO);
    }

    //envia o id para o service deletar
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderCustomerService.delete(id);
    }

}
