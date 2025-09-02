package application.generos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import application.generos.Genero;
import application.generos.record.GeneroDTO;
import application.generos.record.GeneroInsertDTO;
import application.generos.repository.GeneroRepository;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository  generoRepo;

    public Iterable<GeneroDTO> getAll(){
        return generoRepo.findAll().stream().map(GeneroDTO::new).toList();
    }

    public GeneroDTO insert(GeneroInsertDTO dados){
        return new GeneroDTO(generoRepo.save(new Genero(dados)));
    }

    public GeneroDTO getOne(long id){
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gênero não encontrado");   
        }
        return new GeneroDTO(resultado.get());
    }

    public GeneroDTO update(long id, GeneroInsertDTO novosdados){
        Optional<Genero> resultado = generoRepo.findById(id);
        if( resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gênero não encontrado");
        }
        resultado.get().setNome(novosdados.nome());
        return new GeneroDTO(generoRepo.save(resultado.get()));

    }

    public void delete(long id ){
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gênero não encontrado");
        }
        generoRepo.deleteById(id);
    }
    
}
