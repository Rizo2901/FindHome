package com.findhome.dao;

import com.findhome.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository <Categoria, Long> {
    
}
