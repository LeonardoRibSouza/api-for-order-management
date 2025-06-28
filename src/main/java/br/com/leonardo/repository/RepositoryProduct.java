package br.com.leonardo.repository;

import br.com.leonardo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product,Long> {
}
