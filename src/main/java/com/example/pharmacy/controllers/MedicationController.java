package com.example.pharmacy.controllers;


import com.example.pharmacy.repositories.MedicationRepository;
import com.example.pharmacy.resources.MedicationResource;
import com.example.pharmacy.resources.ReportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("medications")
public class MedicationController {

    protected final MedicationRepository medicationRepository;


    public MedicationController(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @GetMapping("")
    public MedicationResource[] getAll(){
        return Arrays.stream(medicationRepository.select())
                .map(MedicationResource::new)
                .toArray(MedicationResource[]::new);
    }
}
