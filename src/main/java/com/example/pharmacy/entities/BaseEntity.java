package com.example.pharmacy.entities;

public class BaseEntity {

    private Integer id;

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
