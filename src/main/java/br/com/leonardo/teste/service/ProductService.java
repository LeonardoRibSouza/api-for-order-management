package br.com.leonardo.teste.service;

import br.com.leonardo.teste.model.Product;
import br.com.leonardo.teste.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    @Autowired
    private RepositoryProduct repository;
    private static final Logger log = Logger.getLogger(ProductService.class.getName());

    public Product create(@RequestBody Product product) {
        log.info("registering product");
        return repository.save(product);
    }


    public List<Product> findAll() {
        log.info("finding all products");
        return repository.findAll();
    }

    public Product update(Product product) {
        log.info("updating product");
        Product entity = repository.findById(product.getId()).get();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setCategory(product.getCategory());
        return repository.save(entity);
    }

    public Product updateProductQuantity(Product product) {
        log.info("updating product");
        Product entity = repository.findById(product.getId()).get();
        entity.setQuantity(product.getQuantity());
        return repository.save(entity);
    }

    public void delete(Long id) {
        log.info("deleting product");
        repository.deleteById(id);
    }
}
