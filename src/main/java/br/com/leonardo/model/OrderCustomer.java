package br.com.leonardo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "order_customer")
public class OrderCustomer implements Serializable {

    private static final Long serialVersionUID = 1L;

    public OrderCustomer() {
        setStatus("order received");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "item_ordered", nullable = false)
    private ArrayList<ItemOrdered> items;

    @Column(name="total", nullable = false)
    private BigDecimal Total;

    @Column(name="status", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public ArrayList<ItemOrdered> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemOrdered> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return Total;
    }

    public void setTotal(BigDecimal total) {
        Total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderCustomer that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getItems(), getTotal(), getStatus());
    }
}
