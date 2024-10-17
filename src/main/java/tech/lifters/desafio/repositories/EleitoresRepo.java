package tech.lifters.desafio.repositories;

import tech.lifters.desafio.models.Eleitores;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EleitoresRepo extends JpaRepository <Eleitores, UUID>{

}
