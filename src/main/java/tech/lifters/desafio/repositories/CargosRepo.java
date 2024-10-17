package tech.lifters.desafio.repositories;

import tech.lifters.desafio.models.Cargos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargosRepo extends JpaRepository <Cargos, UUID>{

}