package com.example.topdownrest.repository;

import com.example.topdownrest.domain.MLModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<MLModel, Long> {
}
