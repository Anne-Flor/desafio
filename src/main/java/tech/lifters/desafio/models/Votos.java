package tech.lifters.desafio.models;

import java.time.LocalDateTime;

// import java.util.ArrayList;
// import java.util.UUID;

import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
// import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
// @NoArgsConstructor
// @AllArgsConstructor
@Table(name = "Votos")
public class Votos {
    @EmbeddedId
    private VotosId id;
    private LocalDateTime data;

    public Votos(VotosId ids, LocalDateTime data) {
        if(ids.getIdEleitor() != null){
            new Votos(ids, LocalDateTime.now()); 
        }else{
            System.out.println("Não é possível votar novamente");
        }
    }
}
