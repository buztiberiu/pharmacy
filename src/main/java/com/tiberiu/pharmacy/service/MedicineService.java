package com.tiberiu.pharmacy.service;

import com.tiberiu.pharmacy.dto.IncreaseDTO;
import com.tiberiu.pharmacy.exception.MedicineNotFoundException;
import com.tiberiu.pharmacy.model.Medicine;
import com.tiberiu.pharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public Medicine findOne(Integer id) throws MedicineNotFoundException{
        Optional<Medicine> optMedicine = medicineRepository.findById(id);

        if (optMedicine.isPresent()) {
            return optMedicine.get();
        }

        throw new MedicineNotFoundException("Medicine not found");
    }

    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public void delete(Integer id) {
        medicineRepository.deleteById(id);
    }

    public Medicine increase(String field, IncreaseDTO increaseDTO) {
        Integer dtoId = increaseDTO.getId();
        Integer value = increaseDTO.getValue();

        Optional<Medicine> optMedicine = medicineRepository.findById(dtoId);

        if (field.equalsIgnoreCase("pieces")) {
            if (optMedicine.isPresent()) {
                Medicine medicine = optMedicine.get();
                Integer increasedPieces = medicine.getPieces() + value;
                medicine.setPieces(increasedPieces);
                return medicineRepository.save(medicine);
            }
        }

        if (field.equalsIgnoreCase("price")) {
            if (optMedicine.isPresent()) {
                Medicine medicine = optMedicine.get();
                Double increasedPrice = medicine.getPrice() + value;
                medicine.setPrice(increasedPrice);
                return medicineRepository.save(medicine);
            }
        }
        return null;
    }

    public Medicine decrease(String field, IncreaseDTO decreaseDTO) {
        Integer dtoId = decreaseDTO.getId();
        Integer value = decreaseDTO.getValue();

        Optional<Medicine> optMedicine = medicineRepository.findById(dtoId);

        if (field.equalsIgnoreCase("pieces")) {
            if (optMedicine.isPresent()) {
                Medicine medicine = optMedicine.get();
                Integer decreasePieces = medicine.getPieces() - value;
                medicine.setPieces(decreasePieces);
                return medicineRepository.save(medicine);
            }
        }

        if (field.equalsIgnoreCase("price")) {
            if (optMedicine.isPresent()) {
                Medicine medicine = optMedicine.get();
                Double decreasePieces = medicine.getPrice() - value;
                medicine.setPrice(decreasePieces);
                return medicineRepository.save(medicine);
            }
        }
        return null;
    }
}
