package application.elenco.record;

import application.elenco.Artista;

public record ArtistaInsertDTO(String nome) {
    public ArtistaInsertDTO(Artista dados){
        this(dados.getNome());
    }
    
}
