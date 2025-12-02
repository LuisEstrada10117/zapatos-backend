
package com.example.zapatomarca.controller;

import com.example.zapatomarca.model.Marca;
import com.example.zapatomarca.repository.MarcaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {
    private final MarcaRepository marcaRepository;
    public MarcaController(MarcaRepository marcaRepository) { this.marcaRepository = marcaRepository; }

    @GetMapping
    public List<Marca> getAll() { return marcaRepository.findAll(); }

    @PostMapping
    public Marca create(@RequestBody Marca marca) { 
        marca.setZapatos(null);
        return marcaRepository.save(marca); 
    }

    @PutMapping("/{id}")
    public Marca update(@PathVariable Long id, @RequestBody Marca marca) {
        Marca m = marcaRepository.findById(id).orElseThrow();
        m.setNombre(marca.getNombre());
        m.setPaisOrigen(marca.getPaisOrigen());
        m.setAnioFundacion(marca.getAnioFundacion());
        m.setDescripcion(marca.getDescripcion());
        // No actualizar zapatos desde aquí
        return marcaRepository.save(m);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { marcaRepository.deleteById(id); }
}
