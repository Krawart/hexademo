package com.krawart.hexademo.core.staff.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.staff.domain.Vet;
import com.krawart.hexademo.core.staff.domain.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class VetJPARepository implements VetRepository {

    private final VetDAO vetDAO;

    @Override
    public Vet add(Vet entity) {
        return vetDAO.save(VetEntity.of(entity)).toDomain();
    }

    @Override
    public Vet update(Vet entity) {
        return vetDAO.save(VetEntity.of(entity)).toDomain();
    }

    @Override
    public Optional<Vet> findById(UUID id) {
        return vetDAO.findById(id).map(VetEntity::toDomain);
    }

    @Override
    public void removeById(UUID id) {
        vetDAO.deleteById(id);
    }
}
