package com.example.pharmacy.entities;

public class Report extends BaseEntity {


    private Integer medication_id;
    private Integer user_id;
    private Boolean status;
    private Integer count;
    private Integer total_cost;
    private String date;

    public Report(Integer id, Integer medication_id, Integer user_id, Boolean status, Integer count, Integer total_cost, String date) {
        super(id);
        this.medication_id = medication_id;
        this.user_id = user_id;
        this.status = status;
        this.count = count;
        this.total_cost = total_cost;
        this.date = date;
    }

    public Integer getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Integer medication_id) {
        this.medication_id = medication_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Integer total_cost) {
        this.total_cost = total_cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return this.getId() + " " + this.getCount() + " " +  this.getMedication_id() + " "
                + this.getTotal_cost() +  " " + this.getDate() + " " + this.getUser_id()  + " " +
                this.getStatus();
    }
}
