package com.example.demo.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.example.demo.infrastructure.persistence.entity.PujaEntity;

import jakarta.persistence.LockModeType;

public interface SpringPujaRepository extends JpaRepository<PujaEntity, Long> {
	List<PujaEntity> findBySubastaId(Long subastaId);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<PujaEntity> findTopBySubastaIdOrderByMontoDesc(Long subastaId);
}