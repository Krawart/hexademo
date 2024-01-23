package com.krawart.hexademo.core.supply.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.supply.domain.Equipment;
import com.krawart.hexademo.core.supply.domain.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class EquipmentJPARepository implements EquipmentRepository {

    private final EquipmentDAO equipmentDAO;

    @Override
    public Equipment add(Equipment entity) {
        return equipmentDAO.save(EquipmentEntity.of(entity)).toDomain();
    }

    @Override
    public Equipment update(Equipment entity) {
        return equipmentDAO.save(EquipmentEntity.of(entity)).toDomain();
    }

    @Override
    public Optional<Equipment> findById(UUID id) {
        return equipmentDAO.findById(id).map(EquipmentEntity::toDomain);
    }

    @Override
    public void removeById(UUID id) {
        equipmentDAO.deleteById(id);
    }
}
