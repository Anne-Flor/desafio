package tech.lifters.desafio.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "Candidatos")
public class Candidatos {
    @Id
    private UUID id; 
    private String nome;
    private Integer numero; 
    private String legenda;
    private String cargo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargos", referencedColumnName = "id")
    private Cargos idCargo; 
    private LocalDateTime criadoEm;
    private LocalDateTime alteradoEm;
    private LocalDateTime deletadoEm;
}
