package br.com.leonardo.teste.repository;

import br.com.leonardo.teste.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct extends JpaRepository<Product,Long> {
}
