package com.krawart.hexademo.core.supply.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.supply.domain.Medicine;
import com.krawart.hexademo.core.supply.domain.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@ApplicationService
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MedicineQueryService {
    private final MedicineRepository medicineRepository;

    public Medicine getById(UUID id) {
        return medicineRepository.getById(id);
    }
}