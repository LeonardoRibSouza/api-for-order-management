package br.com.leonardo.repository;

import br.com.leonardo.model.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrderCustomer extends JpaRepository<OrderCustomer, Long> {
}
