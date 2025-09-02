package application.filmes;

import application.filmes.record.FilmeDTO;
import application.filmes.record.FilmeInsertDTO;
import application.generos.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filmes")
@NoArgsConstructor
@Getter
@Setter
public class Filmes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Filmes(FilmeDTO dados){
        this.setId(dados.id());
        this.setTitulo(dados.titulo());
        this.setGenero(new Genero(dados.genero()));
    }

    public Filmes(FilmeInsertDTO dados){
        this.setTitulo(dados.titulo());
        Genero genero = new Genero();
        genero.setId(dados.idGenero());
        this.setGenero(genero);
    }

}
