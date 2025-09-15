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

import application.elenco.record.ArtistaDTO;
import application.elenco.record.ArtistaInsertDTO;
import application.elenco.service.ArtistaService;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaService service;

    @GetMapping
    public Iterable<ArtistaDTO> getAll(){
        return service.getAll();
    }

    @PostMapping
    public ArtistaDTO insert(@RequestBody ArtistaInsertDTO novoArtista){
        return service.insert(novoArtista);
    }
    
    @GetMapping("/{id}")
    public ArtistaDTO getOne(@PathVariable long id ){
        return service.getOne(id);
    }
    @PutMapping("/{id}")
    public ArtistaDTO update(@PathVariable long id, @RequestBody ArtistaInsertDTO novosDados){
        return service.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
