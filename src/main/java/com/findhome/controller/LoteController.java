package com.findhome.controller;

import com.findhome.domain.Lote;
import com.findhome.services.CategoriaService;
import com.findhome.services.LoteService;
import com.findhome.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/lote")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("listado")
    public String listado(Model model) {
        var lotes = loteService.getLotes();

        model.addAttribute("lotes", lotes);
        model.addAttribute("totalLotes", lotes.size());

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categoria", categorias);

        return "/lote/listado";
    }

    @GetMapping("/listado02")
    public String listado02(Model model) {
        var lotes = loteService.getLotes();
        model.addAttribute("lotes", lotes);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categoria", categorias);
        return "/lote/listado02";
    }

    @GetMapping("/nuevo")
    public String loteNuevo(Lote lote) {
        return "/lote/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String loteGuardar(Lote lote,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            loteService.save(lote);
            lote.setRutaImagen(
                    firebaseStorageService.cargaImagen(imagenFile, "lote", lote.getIdLote()));
        }
        loteService.save(lote);
        return "redirect:/lote/listado";
    }

    @GetMapping("/eliminar/{idLote}")
    public String loteEliminar(Lote lote) {
        loteService.delete(lote);
        return "redirect:/lote/listado";
    }

    @GetMapping("/modifica/{idLote}")
    public String loteModificar(Lote lote, Model model) {
        lote = loteService.getLote(lote);
        model.addAttribute("lote", lote);
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/lote/modifica";
    }
}
