package tech.lifters.desafio.models;

import java.time.LocalDateTime;

import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Votos")
public class Votos {
    @EmbeddedId
    private VotosId id;
    private LocalDateTime data;
}
