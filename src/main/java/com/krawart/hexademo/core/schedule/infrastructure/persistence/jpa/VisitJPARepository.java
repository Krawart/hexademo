package com.krawart.hexademo.core.schedule.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.core.schedule.domain.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class VisitJPARepository implements VisitRepository {

    private final VisitDAO visitDAO;

    @Override
    public Visit add(Visit entity) {
        return visitDAO.save(VisitEntity.of(entity)).toDomain();
    }

    @Override
    public Visit update(Visit entity) {
        return visitDAO.save(VisitEntity.of(entity)).toDomain();
    }

    @Override
    public Optional<Visit> findById(UUID id) {
        return visitDAO.findById(id).map(VisitEntity::toDomain);
    }

    @Override
    public void removeById(UUID id) {
        visitDAO.deleteById(id);
    }
}
