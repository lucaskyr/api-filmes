package application.elenco.record;

import application.elenco.Elenco;
import application.filmes.record.FilmeDTO;

public record ElencoDTO(long id, FilmeDTO filme, ArtistaDTO artista, FuncaoDTO funcao) {
    public ElencoDTO(Elenco dados){
        this(dados.getId(),new FilmeDTO(dados.getFilme()),new ArtistaDTO(dados.getArtista()),new FuncaoDTO(dados.getFuncao()));
    }
}
