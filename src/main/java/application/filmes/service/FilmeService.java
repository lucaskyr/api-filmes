package application.filmes.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.filmes.Filmes;
import application.filmes.record.FilmeDTO;
import application.filmes.record.FilmeInsertDTO;
import application.filmes.repository.FilmeRepository;
import application.generos.Genero;
import application.generos.service.GeneroService;
import application.produtora.Produtora;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepo;
    @Autowired
    private GeneroService generoService;

    public Iterable<FilmeDTO> getAll(){
        return filmeRepo.findAll().stream().map(FilmeDTO::new).toList();
    }

    public FilmeDTO insert(FilmeInsertDTO novoFilme){
        Genero genero = new Genero(generoService.getOne(novoFilme.idGenero()));
        Set<Produtora> produtoras = novoFilme.idProdutoras().stream().map(p-> new Produtora(p)).collect(Collectors.toSet());
        
        Filmes filme = new Filmes();
        filme.setTitulo(novoFilme.titulo());
        filme.setGenero(genero);
        filme.setProdutoras(produtoras);

        return new FilmeDTO(filmeRepo.save(filme));
    }

    public FilmeDTO update(long id, FilmeInsertDTO novosdados){
        Optional<Filmes> resultado = filmeRepo.findById(id);
        Set<Produtora> produtoras = novosdados.idProdutoras().stream().map(p-> new Produtora(p)).collect(Collectors.toSet());
        

        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Filme nao encontrado");
        }
        Genero genero = new Genero(generoService.getOne(novosdados.idGenero()));

        resultado.get().setTitulo(novosdados.titulo());
        resultado.get().setGenero(genero);
        resultado.get().setProdutoras(produtoras);

        return new FilmeDTO(filmeRepo.save(resultado.get()));
    }

    public FilmeDTO getOne(long id ){
        Optional<Filmes> resultado = filmeRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Filme nao encontrado");
        }
        return new FilmeDTO(resultado.get());
    }

    public void delete(long id){
        if(!filmeRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Filme nao encontrado");
        }
        filmeRepo.deleteById(id);
    }
    
} 
