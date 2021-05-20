package com.example.pharmacy.entities;

public class Medication extends BaseEntity {

    private String name;
    private Integer price;
    private Integer count;
    private String main_activity_ingredient;
    private String code_product;
    private String type_id;

    public Medication(Integer id, String name, Integer price, Integer count, String main_activity_ingredient, String code_product, String type_id) {
        super(id);
        this.name = name;
        this.price = price;
        this.count = count;
        this.main_activity_ingredient = main_activity_ingredient;
        this.code_product = code_product;
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMain_activity_ingredient() {
        return main_activity_ingredient;
    }

    public void setMain_activity_ingredient(String main_activity_ingredient) {
        this.main_activity_ingredient = main_activity_ingredient;
    }

    public String getCode_product() {
        return code_product;
    }

    public void setCode_product(String code_product) {
        this.code_product = code_product;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }




}
