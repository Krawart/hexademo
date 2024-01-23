package com.krawart.hexademo.core.store.application;

import com.krawart.hexademo.common.application.ApplicationService;
import com.krawart.hexademo.core.store.application.command.AddMedicineCommand;
import com.krawart.hexademo.core.store.application.command.UpdateMedicineCommand;
import com.krawart.hexademo.core.store.domain.Medicine;
import com.krawart.hexademo.core.store.domain.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ApplicationService
@Transactional
@RequiredArgsConstructor
public class MedicineManager {
    private final MedicineRepository medicineRepository;

    public Medicine add(AddMedicineCommand command) {
        return medicineRepository.add(
                Medicine.builder().name(command.name()).weight(command.weight()).build());
    }

    public Medicine update(UpdateMedicineCommand command, UUID id) {
        var persistedEntity = medicineRepository.getById(id);

        persistedEntity.setName(command.name());
        persistedEntity.setWeight(command.weight());

        return persistedEntity;
    }

    public void deleteById(UUID id) {
        medicineRepository.removeById(id);
    }
}
