package com.findhome.dao;

import com.findhome.domain.Local;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalDao extends JpaRepository<Local, Long> {
    public List<Local> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
