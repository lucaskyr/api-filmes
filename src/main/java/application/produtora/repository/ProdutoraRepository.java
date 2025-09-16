package application.produtora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.produtora.Produtora;

public interface ProdutoraRepository extends JpaRepository<Produtora, Long>{
    
}
