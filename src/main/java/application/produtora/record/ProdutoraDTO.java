package application.produtora.record;

import application.produtora.Produtora;

public record ProdutoraDTO(long id, String nome) {
    public ProdutoraDTO(Produtora dados){
        this(dados.getId(), dados.getNome());
    }
}
