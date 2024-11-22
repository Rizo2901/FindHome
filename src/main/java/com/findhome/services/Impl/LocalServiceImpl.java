package com.findhome.services.impl;

import com.findhome.dao.LocalDao;
import com.findhome.domain.Local;
import com.findhome.services.LocalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocalServiceImpl implements LocalService{
    
    @Autowired
    private LocalDao localDao;

    @Override
    @Transactional(readOnly = true)
    public List<Local> getLocales() {
        var locales = localDao.findAll();
        
        return locales;
    }

    @Override
    @Transactional(readOnly = true)
    public Local getLocal(Local local) {
        return localDao.findById(local.getIdLocal()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Local local) {
        localDao.save(local);
    }

    @Override
    @Transactional
    public void delete(Local local) {
        localDao.delete(local);
    }

    @Override
    public List<Local> consultaQuery(double precioinf, double precioSup) {
        return localDao.findByPrecioBetweenOrderByDescripcion(precioinf, precioSup);
    }
    
}
