package tech.lifters.desafio.models;

import java.time.LocalDateTime;

import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Votos")
public class Votos {
    @EmbeddedId
    private VotosId id;
    private LocalDateTime data;

    // public Votos Votos(VotosId ids, LocalDateTime data) {
    //     if(ids.getIdEleitor() != null){
    //         Votos voto = new Votos(ids, LocalDateTime.now()); 
    //     }else{
    //         System.out.println("Não é possível votar novamente");
    //     }
    //     return voto;

    // }
}
