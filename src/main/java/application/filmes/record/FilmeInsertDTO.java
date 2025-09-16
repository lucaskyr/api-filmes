package application.filmes.record;

import java.util.List;

public record FilmeInsertDTO(String titulo, long idGenero, List<Long> idProdutoras) {

}
