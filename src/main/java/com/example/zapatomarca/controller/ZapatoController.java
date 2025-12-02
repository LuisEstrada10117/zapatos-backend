
package com.example.zapatomarca.controller;

import com.example.zapatomarca.model.Zapato;
import com.example.zapatomarca.repository.ZapatoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/zapatos")
@CrossOrigin(origins = "http://localhost:4200")
public class ZapatoController {
    private final ZapatoRepository zapatoRepository;
    public ZapatoController(ZapatoRepository zapatoRepository) { this.zapatoRepository = zapatoRepository; }

    @GetMapping
    public List<Zapato> getAll() { return zapatoRepository.findAll(); }

    @PostMapping
    public Zapato create(@RequestBody Zapato zapato) { return zapatoRepository.save(zapato); }

    @PutMapping("/{id}")
    public Zapato update(@PathVariable Long id, @RequestBody Zapato zapato) {
        Zapato z = zapatoRepository.findById(id).orElseThrow();
        z.setModelo(zapato.getModelo());
        z.setPrecio(zapato.getPrecio());
        z.setTalla(zapato.getTalla());
        z.setMarca(zapato.getMarca());
        return zapatoRepository.save(z);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { zapatoRepository.deleteById(id); }
}
