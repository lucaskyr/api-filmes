package application.filmes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import application.filmes.record.FilmeDTO;
import application.filmes.record.FilmeInsertDTO;
import application.generos.Genero;
import application.produtora.Produtora;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name="filmes_produtoras",
     joinColumns = @JoinColumn(name="id_filme"),
     inverseJoinColumns = @JoinColumn(name="id_produtora"))
    private  Set<Produtora> produtoras;

    public Filmes(FilmeDTO dados){
        this.setId(dados.id());
        this.setTitulo(dados.titulo());
        this.setGenero(new Genero(dados.genero()));
        this.setProdutoras(dados.produtoras().stream().map(Produtora::new).collect(Collectors.toSet()));
    }

    public Filmes(FilmeInsertDTO dados){
        this.setTitulo(dados.titulo());
        Genero genero = new Genero();
        genero.setId(dados.idGenero());
        this.setGenero(genero);

        Set<Produtora> produtoras = dados.idProdutoras().stream().map(p -> new Produtora(p)).collect(Collectors.toSet());
        this.setProdutoras(produtoras);
    }

}
