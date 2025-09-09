package application.elenco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.elenco.Artista;

public interface ArtistaRepository extends JpaRepository<Artista,Long>{
    
}
