package tech.lifters.desafio.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class VotosId implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidatos", referencedColumnName = "id")
    private Candidatos idCandidato;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eleitores", referencedColumnName = "id")
    private Eleitores idEleitor;
}
