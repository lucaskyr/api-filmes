package application.produtora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.produtora.record.ProdutoraDTO;
import application.produtora.record.ProdutoraInsertDTO;
import application.produtora.service.ProdutoraService;

@RestController
@RequestMapping("/produtoras")
public class ProdutoraController {
    @Autowired
    private ProdutoraService service;

    @GetMapping
    public Iterable<ProdutoraDTO>getAll(){
        return service.getAll();
    }

    @PostMapping
    public ProdutoraDTO insert(@RequestBody ProdutoraInsertDTO NovaProdutora){
        return service.insert(NovaProdutora);
    }

    @GetMapping("/{id}")
    public ProdutoraDTO getOne(long id ){
        return service.getOne(id);
    }

    @PutMapping("/{id}")
    public ProdutoraDTO update(@PathVariable long id, @RequestBody ProdutoraInsertDTO novosdados){
        return service.update(id, novosdados);
    }
    
}
