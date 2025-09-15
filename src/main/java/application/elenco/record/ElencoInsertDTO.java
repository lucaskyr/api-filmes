package application.elenco.record;

import application.elenco.Elenco;

public record ElencoInsertDTO(long idFilme, Long idArtista, Long idFuncao) {
    public ElencoInsertDTO(Elenco dados) {
        this(dados.getFilme().getId(), dados.getArtista().getId(), dados.getFuncao().getId());
    }

}
