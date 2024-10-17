package tech.lifters.desafio.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cargos")
public class Cargos {
    @Id
    private UUID id; 
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime alteradoEm;
    private LocalDateTime deletadoEm;
}
