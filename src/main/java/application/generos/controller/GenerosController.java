package application.generos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.generos.record.GeneroDTO;
import application.generos.record.GeneroInsertDTO;
import application.generos.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GenerosController {
    @Autowired
    private GeneroService service;

    @GetMapping
    public Iterable<GeneroDTO>getAll(){
        return service.getAll();
    }

    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroInsertDTO novoGenero){
        return service.insert(novoGenero);
    }

    @GetMapping("/{id}")
    public GeneroDTO getOne(long id ){
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public GeneroDTO update( @PathVariable long id, @RequestBody GeneroInsertDTO novosdados){
        return service.update(id, novosdados);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }


    

}
