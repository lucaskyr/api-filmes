package application.elenco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.elenco.Funcao;
import application.elenco.record.FuncaoDTO;
import application.elenco.record.FuncaoInsertDTO;
import application.elenco.repository.FuncaoRepository;


@Service
public class FuncaoService {
    @Autowired
    private FuncaoRepository funcaoRepo;

    public Iterable<FuncaoDTO>getAll(){
        return funcaoRepo.findAll().stream().map(FuncaoDTO::new).toList();
    }

    public FuncaoDTO insert(FuncaoInsertDTO novaFuncao){
        return new FuncaoDTO(funcaoRepo.save(new Funcao(novaFuncao)));
    }

    public FuncaoDTO getOne(long id){
        Optional<Funcao>resultado = funcaoRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Função não encontrada");
        }
        return new FuncaoDTO(resultado.get());
    }

    public FuncaoDTO update(long id, FuncaoInsertDTO novosDados){
        Optional<Funcao> resultado = funcaoRepo.findById(id);
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Função não encontrada");
        }
        resultado.get().setDescricao(novosDados.descricao());
        return new FuncaoDTO(funcaoRepo.save(resultado.get()));
    }
    
    public void delete(long id){
        Optional<Funcao> resultado = funcaoRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Função não encontrada");
        }
        funcaoRepo.deleteById(id);
    }
}
