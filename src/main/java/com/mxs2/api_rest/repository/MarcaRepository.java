package com.mxs2.api_rest.repository;

import com.mxs2.api_rest.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}