package com.findhome.services;

import com.findhome.domain.Lote;
import java.util.List;

public interface LoteService {

    public List<Lote> getLotes();

    public Lote getLote(Lote lote);

    public void save(Lote lote);

    public void delete(Lote lote);
    
    public List<Lote> consultaQuery(double precioInf, double precioSup);
}
