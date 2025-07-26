package com.mxs2.api_rest.repository;

import com.mxs2.api_rest.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}