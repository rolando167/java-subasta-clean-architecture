package com.example.demo.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infrastructure.persistence.entity.SubastaEntity;

public interface SpringSubastaRepository extends JpaRepository<SubastaEntity, Long> {
	List<SubastaEntity> findByEstado(String estado);
}