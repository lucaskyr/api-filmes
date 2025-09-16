package application.produtora;

import application.produtora.record.ProdutoraDTO;
import application.produtora.record.ProdutoraInsertDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "produtora")
@Setter
@NoArgsConstructor
public class Produtora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    @Column(unique = true, nullable = false)
    private String nome;

    public Produtora(ProdutoraDTO dados){
        this.setId(dados.id());
        this.setNome(dados.nome());
    }

    public Produtora(ProdutoraInsertDTO dados){
        this.setNome(dados.nome());
    }
}
