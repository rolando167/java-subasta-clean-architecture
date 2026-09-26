package com.example.demo.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infrastructure.persistence.entity.ArticuloEntity;

public interface SpringArticuloRepository extends JpaRepository<ArticuloEntity, Long> {
}