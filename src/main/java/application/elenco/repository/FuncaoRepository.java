package application.elenco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.elenco.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
    
}
