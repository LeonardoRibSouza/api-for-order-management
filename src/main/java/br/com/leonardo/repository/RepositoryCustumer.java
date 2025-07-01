package br.com.leonardo.repository;

import br.com.leonardo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCustumer extends JpaRepository<Customer,Long> {
    boolean existsByCpf(String cpf);
}
