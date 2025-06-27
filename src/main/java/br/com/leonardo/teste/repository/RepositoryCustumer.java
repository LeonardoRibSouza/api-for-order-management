package br.com.leonardo.teste.repository;

import br.com.leonardo.teste.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCustumer extends JpaRepository<Customer,Long> {
}
