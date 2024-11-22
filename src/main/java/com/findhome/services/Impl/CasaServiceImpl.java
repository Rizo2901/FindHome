package com.findhome.services.impl;

import com.findhome.dao.CasaDao;
import com.findhome.domain.Casa;
import com.findhome.services.CasaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CasaServiceImpl implements CasaService{
    
    @Autowired
    private CasaDao casaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Casa> getCasas() {
        var casas = casaDao.findAll();
        
        return casas;
    }

    @Override
    @Transactional(readOnly = true)
    public Casa getCasa(Casa casa) {
        return casaDao.findById(casa.getIdCasa()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Casa casa) {
        casaDao.save(casa);
    }

    @Override
    @Transactional
    public void delete(Casa casa) {
        casaDao.delete(casa);
    }

    @Override
    public List<Casa> consultaQuery(double precioInf, double precioSup) {
        return casaDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
}
