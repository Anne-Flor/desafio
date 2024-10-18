package tech.lifters.desafio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Eleitores")
@XmlRootElement(name = "Eleitores")
public class Eleitores {
    @Id
    private UUID id; 
    private String nome;
    private Integer cpf;
    private LocalDateTime criadoEm;
    private LocalDateTime alteradoEm;
    private LocalDateTime deletadoEm;

}


