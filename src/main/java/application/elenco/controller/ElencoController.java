package application.elenco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.elenco.Elenco;
import application.elenco.record.ElencoDTO;
import application.elenco.record.ElencoInsertDTO;
import application.elenco.service.ElencoService;

@RestController
@RequestMapping("/elencos")
public class ElencoController {

    @Autowired
    private ElencoService elencoService;

    @PostMapping
    public ElencoDTO insert(@RequestBody ElencoInsertDTO dados){
        return elencoService.insert(dados);
    }

    @PutMapping("/{id}")
    public ElencoDTO update(@PathVariable Long id, @RequestBody ElencoInsertDTO dados){
        return elencoService.update(id, dados);
    }
}
