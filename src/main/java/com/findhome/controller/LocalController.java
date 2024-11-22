package com.findhome.controller;

import com.findhome.domain.Local;
import com.findhome.services.*;
import com.findhome.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("listado")
    public String listado(Model model) {
        var locales = localService.getLocales();

        model.addAttribute("locales", locales);
        model.addAttribute("totalLocales", locales.size());

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categoria", categorias);

        return "/local/listado";
    }

    @GetMapping("/listado02")
    public String listado02(Model model) {
        var locales = localService.getLocales();
        model.addAttribute("locales", locales);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categoria", categorias);
        return "/local/listado02";
    }

    @GetMapping("/nuevo")
    public String localNuevo(Local local, Model model) {
        var locales = localService.getLocales();

        model.addAttribute("locales", locales);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/local/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String localGuardar(Local local,@RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            localService.save(local);
            local.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "local", local.getIdLocal()));
        }
        localService.save(local);
        return "redirect:/local/listado";
    }

    @GetMapping("/eliminar/{idLocal}")
    public String localEliminar(Local local) {
        localService.delete(local);
        return "redirect:/local/listado";
    }

    @GetMapping("/modifica/{idLocal}")
    public String localModificar(Local local, Model model) {
        local = localService.getLocal(local);
        model.addAttribute("local", local);
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/local/modifica";
    }
}
