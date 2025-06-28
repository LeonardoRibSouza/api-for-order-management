package br.com.leonardo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false, length = 100)
    private String name;

    @Column(name="cpf", nullable=false, length = 100)
    private String cpf;

    @Column(name="telephone", nullable=false, length = 100)
    private String telephone;

    @Column(name="address", nullable=false, length = 100)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customers)) return false;
        return Objects.equals(getId(), customers.getId()) && Objects.equals(getName(), customers.getName()) && Objects.equals(getCpf(), customers.getCpf()) && Objects.equals(getTelephone(), customers.getTelephone()) && Objects.equals(getAddress(), customers.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCpf(), getTelephone(), getAddress());
    }
}
