package tech.lifters.desafio.controllers;

import tech.lifters.desafio.models.Candidatos;
import tech.lifters.desafio.models.Eleitores;
import tech.lifters.desafio.models.Votos;
import tech.lifters.desafio.models.VotosId;

import java.util.UUID;
import java.util.Optional;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import tech.lifters.desafio.repositories.CandidatosRepo;
import tech.lifters.desafio.repositories.EleitoresRepo;
import tech.lifters.desafio.repositories.VotosRepo;

@RestController
public class EleitoresController {
    @Autowired
    private EleitoresRepo repository;
    private CandidatosRepo CandidatosRepo;
    private VotosRepo VotosRepo;

    public EleitoresController(EleitoresRepo repository) {
        this.repository = repository;
    }

    @PostMapping("/eleitores/{eleitoresId}/votar")
    public Optional<Votos> votar(@PathVariable UUID eleitoresId, @RequestBody UUID candidatosId) {
        Eleitores eleitores = repository.findById(eleitoresId)
            .orElseThrow(() -> new RuntimeException("Eleitores id not found - " + eleitoresId));
        Candidatos candidatos = CandidatosRepo.findById(candidatosId)
            .orElseThrow(() -> new RuntimeException("Candidatos id not found - " + candidatosId));
        VotosId votoId = new VotosId(candidatos, eleitores);
        Optional<Votos> voto = VotosRepo.findById(votoId);
        return voto;
    }

    @GetMapping("/eleitores")
    public List<Eleitores> findAllEleitores() {
        return repository.findAll();
    }

    @GetMapping("/eleitores/{eleitoresId}")
    public Eleitores getEleitores(@PathVariable UUID eleitoresId) {
        Eleitores eleitores = repository.findById(eleitoresId)
            .orElseThrow(() -> new RuntimeException("Eleitores id not found - " + eleitoresId));
        return eleitores;
    }

    @PostMapping("/eleitores")
    public Eleitores addEleitores(@RequestBody Eleitores eleitores) {
        Eleitores newEleitores = repository.save(eleitores);
        return newEleitores;
    }

    @PutMapping("/eleitores/{eleitoresId}")
    public Eleitores updateEleitores(@RequestBody Eleitores eleitores) {
        Eleitores theEleitores = repository.save(eleitores);
        return theEleitores;
    }

    @DeleteMapping("/eleitores/{eleitoresId}")
    public String deleteEleitores(@PathVariable UUID eleitoresId) {
    Eleitores eleitores = repository.findById(eleitoresId)
            .orElseThrow(() -> new RuntimeException("Eleitores id not found - " + eleitoresId));
            repository.delete(eleitores);
        return "Deleted eleitores with id: " + eleitoresId;
    }
}
