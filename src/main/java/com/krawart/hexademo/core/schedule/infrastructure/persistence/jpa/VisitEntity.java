package com.krawart.hexademo.core.schedule.infrastructure.persistence.jpa;

import com.krawart.hexademo.core.schedule.domain.Visit;
import com.krawart.hexademo.shared.infrastructure.persistence.jpa.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class VisitEntity extends AuditableEntity {

    @Column(name = "date")
    private Instant date;

    @Column(name = "description")
    private String description;

    @Column(name = "pet_id")
    private UUID petId;

    static VisitEntity of(Visit visit) {
        return VisitEntity.builder()
                .id(visit.getId())
                .date(visit.getDate())
                .description(visit.getDescription())
                .petId(visit.getPetId())
                .build();
    }

    Visit toDomain() {
        return Visit.builder()
                .id(getId())
                .date(getDate())
                .description(getDescription())
                .petId(getPetId())
                .build();
    }
}
