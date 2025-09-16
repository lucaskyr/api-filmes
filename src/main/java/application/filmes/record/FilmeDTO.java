package application.filmes.record;

import java.util.List;
import java.util.Set;

import application.filmes.Filmes;
import application.generos.record.GeneroDTO;
import application.produtora.record.ProdutoraDTO;

public record FilmeDTO(long id, String titulo, GeneroDTO genero, List<ProdutoraDTO> produtoras) {
    public FilmeDTO(Filmes dados){
        this(dados.getId(), 
        dados.getTitulo(), 
        new GeneroDTO(dados.getGenero()),
        dados.getProdutoras().stream().map(ProdutoraDTO::new).toList());
    }
}
