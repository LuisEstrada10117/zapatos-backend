package com.example.zapatomarca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "zapatos")
public class Zapato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id_zapato")
    private Long idZapato;

    private String modelo;
    private double precio;
    private int talla;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    @JsonIgnoreProperties("zapatos")
    private Marca marca;

    public Zapato() {}

    public Zapato(Long idZapato, String modelo, double precio, int talla, Marca marca) {
        this.idZapato = idZapato;
        this.modelo = modelo;
        this.precio = precio;
        this.talla = talla;
        this.marca = marca;
    }

    public Long getIdZapato() { 
        return idZapato; 
    }
    
    public void setIdZapato(Long idZapato) { 
        this.idZapato = idZapato; 
    }
    
    public String getModelo() { 
        return modelo; 
    }
    
    public void setModelo(String modelo) { 
        this.modelo = modelo; 
    }
    
    public double getPrecio() { 
        return precio; 
    }
    
    public void setPrecio(double precio) { 
        this.precio = precio; 
    }
    
    public int getTalla() { 
        return talla; 
    }
    
    public void setTalla(int talla) { 
        this.talla = talla; 
    }
    
    public Marca getMarca() { 
        return marca; 
    }
    
    public void setMarca(Marca marca) { 
        this.marca = marca; 
    }
}
