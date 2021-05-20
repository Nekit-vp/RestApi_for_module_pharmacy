package com.example.pharmacy.controllers;


import com.example.pharmacy.entities.Medication;
import com.example.pharmacy.entities.Report;
import com.example.pharmacy.repositories.MedicationRepository;
import com.example.pharmacy.repositories.ReportRepository;
import com.example.pharmacy.resources.MessageResource;
import com.example.pharmacy.resources.ReportResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("report")
public class ReportController {

    protected final MedicationRepository medicationRepository;
    protected final ReportRepository reportRepository;

    @Autowired
    public ReportController(MedicationRepository medicationRepository, ReportRepository reportRepository) {
        this.medicationRepository = medicationRepository;
        this.reportRepository = reportRepository;
    }

    @GetMapping("")
    public ReportResource[] getAll(){
        return Arrays.stream(reportRepository.select())
                .map(ReportResource::new)
                .toArray(ReportResource[]::new);
    }

    @PostMapping("")
    public MessageResource post(@RequestBody ReportResource reportResource) {

        Report report = reportResource.toEntity();
        Medication medication = medicationRepository.select(report.getMedication_id());

        report.setDate(new Date().toString());
        report.setTotal_cost(medication.getPrice() * report.getCount());

        if (medication.getCount() < report.getCount()) {
            report.setStatus(false);
            reportRepository.insert(report);
            return new MessageResource("Sorry, we don't have so many medications");
        } else
        {
            report.setStatus(true);
            reportRepository.insert(report);
            Integer new_value = medication.getCount() - report.getCount();
            medicationRepository.update(report.getMedication_id(), new_value);
            return  new MessageResource("Yes, your request were submit");
        }
    }
}
