package com.mxs2.api_rest.repository;

import com.mxs2.api_rest.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, String> {
    
    @Query("SELECT c FROM Carro c WHERE c.ano BETWEEN :anoInicial AND :anoFinal")
    List<Carro> findByAnoBetween(@Param("anoInicial") Integer anoInicial, @Param("anoFinal") Integer anoFinal);
}