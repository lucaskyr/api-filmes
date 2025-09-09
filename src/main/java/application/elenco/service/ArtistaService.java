package application.elenco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.elenco.Artista;
import application.elenco.record.ArtistaDTO;
import application.elenco.record.ArtistaInsertDTO;
import application.elenco.repository.ArtistaRepository;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepo;

    public Iterable<ArtistaDTO>getAll(){
        return artistaRepo.findAll().stream().map(ArtistaDTO::new).toList();
    }

    public ArtistaDTO insert(ArtistaInsertDTO novoArtista){
        return new ArtistaDTO(artistaRepo.save(new Artista(novoArtista)));
    }
    
    public ArtistaDTO getOne(long id){
        Optional<Artista>resultado = artistaRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado");
        }
        return new ArtistaDTO(resultado.get());
    }

    public ArtistaDTO update(long id, ArtistaInsertDTO novosDados){
        Optional<Artista> resultado = artistaRepo.findById(id);
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado");
        }
        resultado.get().setNome(novosDados.nome());
        return new ArtistaDTO(artistaRepo.save(resultado.get()));
    }
    
    public void delete(long id){
        Optional<Artista> resultado = artistaRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado");
        }
        artistaRepo.deleteById(id);
    }
}
