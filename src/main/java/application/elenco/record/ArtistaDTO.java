package application.elenco.record;

import application.elenco.Artista;

public record ArtistaDTO(long id, String nome) {
    public ArtistaDTO(Artista dados){
        this(dados.getId(), dados.getNome());
    }
    
}
