package application.elenco.record;

import application.elenco.Funcao;

public record FuncaoDTO(Long id, String descricao) {
    public FuncaoDTO(Funcao dados){
        this(dados.getId(),dados.getDescricao());
    }
}