package com.findhome.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="locales")
public class Local {
    
        private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_local")
    private Long idLocal;
    private String descripcion;
    private String metrosCuadrados;
    private double precio;
    private int contacto;
    private String ubicacion;
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;

    public Local(String descripcion, String metrosCuadrados, double precio, int contacto, String ubicacion, String rutaImagen) {
        this.descripcion = descripcion;
        this.metrosCuadrados = metrosCuadrados;
        this.precio = precio;
        this.contacto = contacto;
        this.ubicacion = ubicacion;
        this.rutaImagen = rutaImagen;
    }

    public Local() {
    }
}
