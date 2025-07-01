package br.com.leonardo.data.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProductDTO() {
        setCreatedAt(LocalDateTime.now());
        setStatus(true);
    }
    private Long id;

    private String code;

    private String brand;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductDTO product)) return false;
        return isStatus() == product.isStatus() && Objects.equals(getId(), product.getId()) && Objects.equals(getCode(), product.getCode()) && Objects.equals(getBrand(), product.getBrand()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getQuantity(), product.getQuantity()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getCreatedAt(), product.getCreatedAt()) && Objects.equals(getUpdatedAt(), product.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getBrand(), getName(), getDescription(), getPrice(), getQuantity(), getCategory(), getCreatedAt(), getUpdatedAt(), isStatus());
    }
}
