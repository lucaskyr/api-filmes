package application.filmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.filmes.Filmes;
import application.filmes.record.FilmeDTO;
import application.filmes.record.FilmeInsertDTO;
import application.filmes.service.FilmeService;


@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService service;

    @GetMapping
    public Iterable<FilmeDTO>getAll(){
        return service.getAll();
    }

    @PostMapping
    public FilmeDTO insert(@RequestBody FilmeInsertDTO novoFilme){
        return service.insert(novoFilme);
    }

    @GetMapping("/{id}")
    public FilmeDTO getOne(@PathVariable long id){
        return service.getOne(id);
    }


    @PutMapping("/{id}")
    public FilmeDTO update(@PathVariable long id, @RequestBody FilmeInsertDTO novosdados){
        return service.update(id, novosdados);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }

    
}
