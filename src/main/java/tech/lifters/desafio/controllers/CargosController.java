package tech.lifters.desafio.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;

import tech.lifters.desafio.models.Cargos;
import tech.lifters.desafio.repositories.CargosRepo;

@RestController
public class CargosController {
    @Autowired
    private CargosRepo repository;

    public CargosController(CargosRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/cargos")
    public List<Cargos> findAllCargos() {
        return repository.findAll();
    }

    @GetMapping("/cargos/{cargosId}")
    public Cargos getCargos(@PathVariable UUID cargosId) {
    Cargos cargos = repository.findById(cargosId)
            .orElseThrow(() -> new RuntimeException("Cargos id not found - " + cargosId));
        return cargos;
    }

    @PostMapping("/cargos")
    public Cargos addCargos(@RequestBody Cargos cargos) {
        Cargos newCargos = repository.save(cargos);
        return newCargos;
    }

    @PutMapping("/cargos/{cargosId}")
    public Cargos updateCargos(@RequestBody Cargos cargos) {
        Cargos theCargos = repository.save(cargos);
        return theCargos;
    }

    @DeleteMapping("/cargos/{cargosId}")
    public String deleteCargos(@PathVariable UUID cargosId) {
        Cargos cargos = repository.findById(cargosId)
            .orElseThrow(() -> new RuntimeException("Cargos id not found - " + cargosId));
            repository.delete(cargos);
        return "Deleted cargos with id: " + cargosId;
    }
}
