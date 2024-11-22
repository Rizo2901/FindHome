package com.findhome.dao;

import com.findhome.domain.Casa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaDao extends JpaRepository<Casa, Long>{
    
    public List<Casa> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
