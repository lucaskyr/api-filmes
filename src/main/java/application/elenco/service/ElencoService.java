package application.elenco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import application.elenco.Artista;
import application.elenco.Elenco;
import application.elenco.Funcao;
import application.elenco.record.ElencoDTO;
import application.elenco.record.ElencoInsertDTO;
import application.elenco.repository.ArtistaRepository;
import application.elenco.repository.ElencoRepository;
import application.elenco.repository.FuncaoRepository;
import application.filmes.Filmes;
import application.filmes.repository.FilmeRepository;

@Service
public class ElencoService {
    @Autowired
    private ElencoRepository elencoRepository;
    @Autowired
    private ArtistaRepository artistaRepository;
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private FuncaoRepository funcaoRepository;


    public Iterable<ElencoDTO> getAll(){
        return elencoRepository.findAll().stream().map(ElencoDTO::new).toList();
    }
    
    public ElencoDTO insert(ElencoInsertDTO dados){
        Optional<Filmes> resultadoFilme = filmeRepository.findById(dados.idFilme());
        Optional<Artista> resultadoArtista = artistaRepository.findById(dados.idArtista());
        Optional<Funcao> resultadoFuncao = funcaoRepository.findById(dados.idFuncao());

        String mensagem = "Dados invalidos: ";
        boolean isError = false;
        if(resultadoFilme.isEmpty()){
            if(isError)
                mensagem += ", ";
            mensagem += "Filme nao encontrado";
            isError = true;
        }

        if (resultadoArtista.isEmpty()){
            if(isError)
                mensagem += ", ";
            mensagem += "Artista nao encontrado";
            isError = true; 
        }
        if (resultadoFuncao.isEmpty()){
            if(isError)
                mensagem += ", ";
            mensagem += "Funcao nao encontrada";
            isError = true; 
        }

        if(isError){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, mensagem);
        }

        Elenco novo = new Elenco();
        novo.setFilme(resultadoFilme.get());
        novo.setArtista(resultadoArtista.get());
        novo.setFuncao(resultadoFuncao.get());

        return new  ElencoDTO(elencoRepository.save(novo));
    }

    public ElencoDTO update(Long id, ElencoInsertDTO dados){
        Optional<Elenco> resultado = elencoRepository.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elenco nao encontrado");
        }

        Optional<Filmes> resultadoFilme = filmeRepository.findById(dados.idFilme());
        Optional<Artista> resultadoArtista = artistaRepository.findById(dados.idArtista());
        Optional<Funcao> resultadoFuncao = funcaoRepository.findById(dados.idFuncao());

        String mensagem = "Dados invalidos: ";
        boolean isError = false;
        if(resultadoFilme.isEmpty()){
            if(isError)
                mensagem += ", ";
            mensagem += "Filme nao encontrado";
            isError = true;
        }

        if (resultadoArtista.isEmpty()){
            if(isError)
                mensagem += ", ";
            mensagem += "Artista nao encontrado";
            isError = true; 
        }
        if (resultadoFuncao.isEmpty()){
            if(isError)
                mensagem += ", ";
            mensagem += "Funcao nao encontrada";
            isError = true; 
        }

        if(isError){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, mensagem);
        }

        resultado.get().setFilme(resultadoFilme.get());
        resultado.get().setArtista(resultadoArtista.get());
        resultado.get().setFuncao(resultadoFuncao.get());

        return new  ElencoDTO(elencoRepository.save(resultado.get()));
    }

}