package tech.lifters.desafio.repositories;

import tech.lifters.desafio.models.Votos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotosRepo extends JpaRepository <Votos, UUID>{

}