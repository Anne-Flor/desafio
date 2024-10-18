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
import tech.lifters.desafio.models.Candidatos;
import tech.lifters.desafio.repositories.CandidatosRepo;

@RestController
public class CandidatosController {
    @Autowired
    private CandidatosRepo repository;

    public CandidatosController(CandidatosRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/candidatos")
    public List<Candidatos> findAllCandidatos() {
        return repository.findAll();
    }

    @GetMapping("/candidatos/{candidatosId}")
    public Candidatos getCandidatos(@PathVariable UUID candidatosId) {
    Candidatos candidatos = repository.findById(candidatosId)
            .orElseThrow(() -> new RuntimeException("Eleitores id not found - " + candidatosId));
        return candidatos;
    }

    @PostMapping("/candidatos")
    public Candidatos addCandidatos(@RequestBody Candidatos candidatos) {
        // candidatos.setId(UUID.randomUUID());
        Candidatos newCandidatos = repository.save(candidatos);
        return newCandidatos;
    }

    @PutMapping("/candidatos/{candidatosId}")
    public Candidatos updateCandidatos(@RequestBody Candidatos candidatos) {
        Candidatos theCandidatos = repository.save(candidatos);
        return theCandidatos;
    }

    @DeleteMapping("/candidatos/{candidatosId}")
    public String deleteCandidatos(@PathVariable UUID candidatosId) {
        Candidatos candidatos = repository.findById(candidatosId)
            .orElseThrow(() -> new RuntimeException("Candidatos id not found - " + candidatosId));
            repository.delete(candidatos);
        return "Deleted eleitores with id: " + candidatosId;
    }
}
