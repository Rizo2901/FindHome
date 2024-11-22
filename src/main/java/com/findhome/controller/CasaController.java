package com.findhome.controller;

import com.findhome.domain.Casa;
import com.findhome.services.CasaService;
import com.findhome.services.CategoriaService;
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
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaService casaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("listado")
    public String listado(Model model) {
        var casas = casaService.getCasas();

        model.addAttribute("casas", casas);
        model.addAttribute("totalCasas", casas.size());

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categoria", categorias);

        return "/casa/listado";
    }

    @GetMapping("/listado02")
    public String listado02(Model model) {
        var casas = casaService.getCasas();
        model.addAttribute("casas", casas);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categoria", categorias);
        return "/casa/listado02";
    }

    @GetMapping("/nuevo")
    public String casaNuevo(Casa casa) {
        return "/casa/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String casaGuardar(Casa casa,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            casaService.save(casa);
            casa.setRutaImagen(
                    firebaseStorageService.cargaImagen(imagenFile, "casa", casa.getIdCasa()));
        }
        casaService.save(casa);
        return "redirect:/casa/listado";
    }

    @GetMapping("/eliminar/{idCasa}")
    public String casaEliminar(Casa casa) {
        casaService.delete(casa);
        return "redirect:/casa/listado";
    }

    @GetMapping("/modifica/{idCasa}")
    public String casaModificar(Casa casa, Model model) {
        casa = casaService.getCasa(casa);
        model.addAttribute("casa", casa);

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/casa/modifica";
    }

    @PostMapping("/query1")
    public String consulta1(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {
        var casas = casaService.consultaQuery(precioInf, precioSup);
        model.addAttribute("casas", casas);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/casa/listado";
    }
}
