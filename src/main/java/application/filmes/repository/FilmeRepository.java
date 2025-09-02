package application.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.filmes.Filmes;

public interface FilmeRepository extends JpaRepository<Filmes, Long>{
    
}
