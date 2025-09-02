package application.generos;

import application.generos.record.GeneroDTO;
import application.generos.record.GeneroInsertDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    public Genero(GeneroDTO dados){
        this.setId(dados.id());
        this.setNome(dados.nome());

    }
    public Genero(GeneroInsertDTO dados){
        this.setNome(dados.nome());
    }
    
}
