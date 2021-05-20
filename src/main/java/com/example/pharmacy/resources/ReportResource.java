package com.example.pharmacy.resources;

import com.example.pharmacy.entities.Medication;
import com.example.pharmacy.entities.Report;

public class ReportResource extends BaseResource{


    private Integer id;
    private Integer medication_id;
    private Integer user_id;
    private Boolean status;
    private Integer count;
    private Integer total_cost;
    private String date;

    public ReportResource() {
    }

    public ReportResource(Report report) {
        this.id = report.getId();
        this.medication_id = report.getMedication_id();
        this.user_id  = report.getUser_id();
        this.status = report.getStatus();
        this.count = report.getCount();
        this.total_cost = report.getTotal_cost();
        this.date = report.getDate();
    }

    public Report toEntity(){
        return new Report(this.id, this.medication_id, this.user_id, this.status, this.count, this.total_cost,
                this.date);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
