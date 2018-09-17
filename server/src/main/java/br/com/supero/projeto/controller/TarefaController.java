package br.com.supero.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.supero.projeto.model.Tarefa;
import br.com.supero.projeto.service.TarefaService;

/**
 * Classe responsável para chamada dos serviços.

 * @author Robson Duarte
 * 

*/
@Controller
@RequestMapping(path = "/rest/tarefas")
public class TarefaController {
	
	@Autowired
    private TarefaService tarefaService;

    @GetMapping()
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(tarefaService.listAll(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id", required = true) Integer id) {
        return new ResponseEntity<>(tarefaService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping(path = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Tarefa tarefa) {
        return new ResponseEntity<>(this.tarefaService.create(tarefa), HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<?> update(@Valid @RequestBody Tarefa tarefa) {
        Tarefa update = this.tarefaService.update(tarefa);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) Integer id) {
        this.tarefaService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
