package application.produtora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.generos.record.GeneroInsertDTO;
import application.produtora.Produtora;
import application.produtora.record.ProdutoraDTO;
import application.produtora.record.ProdutoraInsertDTO;
import application.produtora.repository.ProdutoraRepository;

@Service
public class ProdutoraService {
    @Autowired
    private ProdutoraRepository produtoraRepo;

    public Iterable<ProdutoraDTO> getAll(){
        return produtoraRepo.findAll().stream().map(ProdutoraDTO::new).toList();
    }

    public ProdutoraDTO insert(ProdutoraInsertDTO dados){
        return new ProdutoraDTO(produtoraRepo.save(new Produtora(dados)));
    }

    public ProdutoraDTO getOne(long id){
        Optional<Produtora> produtora = produtoraRepo.findById(id);
        if(produtora.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produtora não encontrada");
        }
        return new ProdutoraDTO(produtora.get());
    }
    
    public ProdutoraDTO update(long id, GeneroInsertDTO novosdados){
        Optional<Produtora> produtora = produtoraRepo.findById(id);
        if(produtora.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produtora não encontrada");
        }
        produtora.get().setNome(novosdados.nome());
        return new ProdutoraDTO(produtoraRepo.save(produtora.get()));
    }

    public void delete(long id){
        Optional<Produtora> produtora = produtoraRepo.findById(id);
        if(produtora.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produtora não encontrada");
        }
        produtoraRepo.deleteById(id);
    }
}
