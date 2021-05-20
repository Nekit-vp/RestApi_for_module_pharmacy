package com.example.pharmacy.resources;

import com.example.pharmacy.entities.Medication;

public class MedicationResource extends BaseResource{

    private Integer id;
    private String name;
    private Integer price;
    private Integer count;
    private String main_activity_ingredient;
    private String code_product;
    private String type_id;

    public MedicationResource() {
    }

    public MedicationResource(Medication medication){
        this.id = medication.getId();
        this.name = medication.getName();
        this.price = medication.getPrice();
        this.count = medication.getCount();
        this.main_activity_ingredient = medication.getMain_activity_ingredient();
        this.code_product  = medication.getCode_product();
        this.type_id = medication.getType_id();
    }

    public Medication toEntity(){
        return new Medication(this.id, this.name, this.price, this.count, this.main_activity_ingredient, this.code_product,
                this.type_id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
