package application.filmes.service;

import java.util.Optional;

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
        
        Filmes filme = new Filmes();
        filme.setTitulo(novoFilme.titulo());
        filme.setGenero(genero);

        return new FilmeDTO(filmeRepo.save(filme));
    }

    public FilmeDTO update(long id, FilmeInsertDTO novosdados){
        Optional<Filmes> resultado = filmeRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Filme nao encontrado");
        }
        Genero genero = new Genero(generoService.getOne(novosdados.idGenero()));

        resultado.get().setTitulo(novosdados.titulo());
        resultado.get().setGenero(genero);
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
