package br.com.leonardo.data.dto;

import br.com.leonardo.model.ItemOrdered;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class OrderCustomerDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    public OrderCustomerDTO() {
        setStatus("order received");
    }

    private Long id;

    @NotNull(message="customer_id is required")
    private Long customerId;

    @NotNull(message="items is required")
    private ArrayList<ItemOrdered> items;

    private BigDecimal Total;

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
        if (!(o instanceof OrderCustomerDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getItems(), that.getItems()) && Objects.equals(getTotal(), that.getTotal()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getItems(), getTotal(), getStatus());
    }
}
