package com.findhome.services;

import com.findhome.domain.Local;
import java.util.List;

public interface LocalService {

    public List<Local> getLocales();

    public Local getLocal(Local local);

    public void save(Local local);

    public void delete(Local local);
    
    public List<Local> consultaQuery(double precioinf, double precioSup);
}
