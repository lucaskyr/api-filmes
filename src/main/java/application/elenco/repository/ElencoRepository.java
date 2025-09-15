package application.elenco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.elenco.Elenco;

public interface ElencoRepository extends JpaRepository<Elenco,Long>{
    
}
