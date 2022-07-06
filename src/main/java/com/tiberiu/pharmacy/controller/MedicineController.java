package com.tiberiu.pharmacy.controller;

import com.tiberiu.pharmacy.dto.IncreaseDTO;
import com.tiberiu.pharmacy.exception.MedicineNotFoundException;
import com.tiberiu.pharmacy.model.Medicine;
import com.tiberiu.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("medicines", medicineService.findAll());
        model.addAttribute("medicine", new Medicine());
        return "medicine";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable Integer id, Model model) {
        Medicine medicine;
        try {
            medicine = medicineService.findOne(id);
        } catch (MedicineNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        model.addAttribute("medicine", medicine);
        model.addAttribute("medicines", medicineService.findAll());
        return "medicine";
    }

    @PostMapping
    public String saveMedicine(Medicine medicine, BindingResult result, Model model) {
        medicineService.save(medicine);
        return "redirect:/medicines";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Integer id) {
        medicineService.delete(id);
        return "redirect:/medicines";
    }

    @PutMapping("/increase/{field}")
    public Medicine increasePieces(@PathVariable String field, final @RequestBody IncreaseDTO increaseDTO) {
        return medicineService.increase(field, increaseDTO);
    }

}
