package application.filmes.record;

import application.filmes.Filmes;
import application.generos.record.GeneroDTO;

public record FilmeDTO(long id, String titulo, GeneroDTO genero) {
    public FilmeDTO(Filmes dados){
        this(dados.getId(), 
        dados.getTitulo(), 
        new GeneroDTO(dados.getGenero()));
    }
}
