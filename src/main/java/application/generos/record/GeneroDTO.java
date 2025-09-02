package application.generos.record;

import application.generos.Genero;

public record GeneroDTO(long id, String nome) {
    public GeneroDTO(Genero dados){
        this(dados.getId(),dados.getNome());
    }

    
}
