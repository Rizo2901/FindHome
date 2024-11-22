package com.findhome.services.impl;

import com.findhome.dao.LoteDao;
import com.findhome.domain.Lote;
import com.findhome.services.LoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoteServiceImpl implements LoteService{
    
    @Autowired
    private LoteDao loteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Lote> getLotes() {
        var lotes = loteDao.findAll();
        
        return lotes;
    }

    @Override
    @Transactional(readOnly = true)
    public Lote getLote(Lote lote) {
        return loteDao.findById(lote.getIdLote()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Lote lote) {
        loteDao.save(lote);
    }

    @Override
    @Transactional
    public void delete(Lote lote) {
        loteDao.delete(lote);
    }

    @Override
    public List<Lote> consultaQuery(double precioInf, double precioSup) {
        return loteDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
}
