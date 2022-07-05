package com.tiberiu.pharmacy.restcontroller;

import com.tiberiu.pharmacy.dto.IncreaseDTO;
import com.tiberiu.pharmacy.exception.MedicineNotFoundException;
import com.tiberiu.pharmacy.model.Medicine;
import com.tiberiu.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/medicines")
public class MedicineRestController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> findAll() {
        return medicineService.findAll();
    }

    @GetMapping("/{id}")
    public Medicine findOne(@PathVariable Integer id) {
        try {
            return medicineService.findOne(id);
        } catch (MedicineNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/medicines")
    public Medicine saveMedicine(final @RequestBody Medicine medicine) {
        return medicineService.save(medicine);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Integer id) {
        medicineService.delete(id);
    }

    @PutMapping("/increase/{field}")
    public Medicine updatePieces(@PathVariable String field, final @RequestBody IncreaseDTO increaseDTO) {
        return medicineService.increase(field, increaseDTO);
    }

}
