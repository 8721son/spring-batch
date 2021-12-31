package com.batch.modules.batch.repository;

import com.batch.modules.batch.domain.entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Integer>{
    Optional<BatchEntity> findByStoreAndName(String store, String name);
}
