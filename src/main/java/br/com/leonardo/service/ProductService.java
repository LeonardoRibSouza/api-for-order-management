package br.com.leonardo.service;

import br.com.leonardo.data.dto.ProductDTO;
import br.com.leonardo.exception.BusinessException;
import br.com.leonardo.model.Product;
import br.com.leonardo.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Logger;
import static br.com.leonardo.mapper.ObjectMapper.parseObject;
import static br.com.leonardo.mapper.ObjectMapper.parseListObjects;

@Service
public class ProductService {

    @Autowired
    private RepositoryProduct repository;
    private static final Logger log = Logger.getLogger(ProductService.class.getName());


    public ProductDTO register(@RequestBody ProductDTO product) {
        log.info("registering product");

        if(repository.existsByCode(product.getCode())){
            throw new BusinessException("Product already registered");
        }

        var entity = parseObject(product, Product.class);
        return parseObject(repository.save(entity), ProductDTO.class);
    }


    public List<ProductDTO> findAll() {
        log.info("finding all products");


        return parseListObjects(repository.findAll(), ProductDTO.class);
    }

    public ProductDTO update(ProductDTO product) {
        log.info("updating product");
        var entity = repository.findById(product.getId()).get();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setCategory(product.getCategory());

        return parseObject(repository.save(entity), ProductDTO.class);
    }

    public ProductDTO updateProductQuantity(ProductDTO product) {
        log.info("updating product");
        var entity = repository.findById(product.getId()).get();
        entity.setQuantity(product.getQuantity());

        return parseObject(repository.save(entity), ProductDTO.class);
    }

    public void delete(Long id) {
        log.info("deleting product");
        repository.deleteById(id);
    }
}
