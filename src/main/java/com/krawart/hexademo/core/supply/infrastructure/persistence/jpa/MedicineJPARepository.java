package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Medicine;
import com.krawart.hexademo.core.supply.domain.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class MedicineJPARepository implements MedicineRepository {

    private final MedicineDAO medicineDAO;

    @Override
    public Medicine add(Medicine entity) {
        return medicineDAO.save(MedicineEntity.of(entity)).toDomain();
    }

    @Override
    public Medicine update(Medicine entity) {
        return medicineDAO.save(MedicineEntity.of(entity)).toDomain();
    }

    @Override
    public Optional<Medicine> findById(UUID id) {
        return medicineDAO.findById(id).map(MedicineEntity::toDomain);
    }

    @Override
    public void removeById(UUID id) {
        medicineDAO.deleteById(id);
    }
}
