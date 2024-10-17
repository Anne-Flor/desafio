package tech.lifters.desafio.repositories;

import tech.lifters.desafio.models.Candidatos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatosRepo extends JpaRepository <Candidatos, UUID>{

}