package com.findhome.services;

import com.findhome.domain.Casa;
import java.util.List;

public interface CasaService {

    public List<Casa> getCasas();

    public Casa getCasa(Casa casa);

    public void save(Casa casa);

    public void delete(Casa casa);
    
    public List<Casa> consultaQuery(double precioInf, double precioSup);
}
