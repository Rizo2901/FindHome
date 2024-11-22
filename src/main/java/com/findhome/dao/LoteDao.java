package com.findhome.dao;

import com.findhome.domain.Lote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteDao extends JpaRepository<Lote, Long> {
    
    public List<Lote> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
