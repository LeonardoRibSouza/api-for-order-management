package br.com.leonardo.data.dto;

import java.io.Serializable;
import java.util.Objects;


public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private String telephone;
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
        if (!(o instanceof CustomerDTO customers)) return false;
        return Objects.equals(getId(), customers.getId()) && Objects.equals(getName(), customers.getName()) && Objects.equals(getCpf(), customers.getCpf()) && Objects.equals(getTelephone(), customers.getTelephone()) && Objects.equals(getAddress(), customers.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCpf(), getTelephone(), getAddress());
    }
}
