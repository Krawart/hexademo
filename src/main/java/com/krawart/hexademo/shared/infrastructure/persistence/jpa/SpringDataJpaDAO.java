package com.krawart.hexademo.shared.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface SpringDataJpaDAO<T> extends JpaRepository<T, UUID> {}
