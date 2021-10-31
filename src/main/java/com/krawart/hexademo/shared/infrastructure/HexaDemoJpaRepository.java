package com.krawart.hexademo.shared.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface HexaDemoJpaRepository<T> extends JpaRepository<T, UUID> {
}
