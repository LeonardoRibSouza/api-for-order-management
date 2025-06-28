package br.com.leonardo.repository;

import br.com.leonardo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrder extends JpaRepository<Order, Long> {
}
