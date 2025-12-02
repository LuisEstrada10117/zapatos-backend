package com.example.zapatomarca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id_marca")
    private Long idMarca;
    
    private String nombre;
    
    @Column(name = "pais_origen")
    private String paisOrigen;
    
    @Column(name = "anio_fundacion")
    private Integer anioFundacion;
    
    private String descripcion;
    
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("marca")
    @Schema(description = "opcional: deja [] o envía [{\"idZapato\": 1}, {\"idZapato\": 2}] para asociar zapatos existentes", nullable = true, example = "[{\"idZapato\": 1}]")
    private List<Zapato> zapatos;
    
    public Marca() {}
    
    public Marca(Long idMarca, String nombre, String paisOrigen, Integer anioFundacion, String descripcion) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.anioFundacion = anioFundacion;
        this.descripcion = descripcion;
    }
    
    public Long getIdMarca() {
        return idMarca;
    }
    
    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    public Integer getAnioFundacion() {
        return anioFundacion;
    }
    
    public void setAnioFundacion(Integer anioFundacion) {
        this.anioFundacion = anioFundacion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Zapato> getZapatos() {
        return zapatos;
    }
    
    public void setZapatos(List<Zapato> zapatos) {
        this.zapatos = zapatos;
    }
}
