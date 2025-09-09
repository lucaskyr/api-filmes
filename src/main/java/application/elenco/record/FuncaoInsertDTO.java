package application.elenco.record;

import application.elenco.Funcao;

public record FuncaoInsertDTO(String descricao){
    public FuncaoInsertDTO(Funcao dados){
        this(dados.getDescricao());
    }
    
}
