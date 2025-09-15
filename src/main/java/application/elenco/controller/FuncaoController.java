package application.elenco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.elenco.record.FuncaoDTO;
import application.elenco.record.FuncaoInsertDTO;
import application.elenco.service.FuncaoService;

@RequestMapping("/funcoes")
@RestController
public class FuncaoController {
    @Autowired
    private FuncaoService service;

    @GetMapping
    public Iterable<FuncaoDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FuncaoDTO getOne(@PathVariable long id){
        return service.getOne(id);
    }

    @PostMapping
    public FuncaoDTO insert(@RequestBody FuncaoInsertDTO novosDados){
        return service.insert(novosDados);
    }

    @PutMapping("/{id}")
    public FuncaoDTO update(@PathVariable long id, @RequestBody FuncaoInsertDTO novosDados){
        return service.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){  
        service.delete(id);
    }
}
