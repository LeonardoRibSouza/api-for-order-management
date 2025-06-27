package br.com.leonardo.teste.controller;

import br.com.leonardo.teste.model.Product;
import br.com.leonardo.teste.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product registerProduct (@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping(value = "/findall",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PutMapping(value = "/update",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product updateProduct (@RequestBody Product product) {
        return productService.update(product);
    }

    @PutMapping(value = "/update/quantity",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product updateProductQuantity (@RequestBody Product product) {
        return productService.updateProductQuantity(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct (@PathVariable Long id){
        productService.delete(id);
    }

}
