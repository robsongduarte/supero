package br.com.supero.projeto.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import br.com.supero.projeto.model.Tarefa;

/**
 * Classe responsável por executar testes unitários.

 * @author Robson Duarte
 * 

*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TarefaServiceTest {

    @Autowired
    private TarefaService tarefaService;


    @Test
    public void createTarefa() {
        Tarefa t1 = new Tarefa();
        t1.setStatus(Tarefa.StatusTipo.DONE);
        t1.setTitulo("Teste 1");
        t1.setDescricao("Teste 1");

        Tarefa r1 = this.tarefaService.create(t1);
        Assert.notNull(r1.getId(), "erro ao criar tarefa t1");

        Tarefa t2 = new Tarefa();
        t2.setStatus(Tarefa.StatusTipo.WORKING);
        t2.setTitulo("Teste 2");
        t2.setDescricao("Teste 2");

        Tarefa r2 = this.tarefaService.create(t2);
        Assert.notNull(r2.getId(), "erro ao criar tarefa c2");


        Tarefa t3 = new Tarefa();
        t3.setStatus(Tarefa.StatusTipo.TODO);
        t3.setTitulo("Teste 3");
        t3.setDescricao("Teste 3");

        Tarefa r3 = this.tarefaService.create(t3);
        Assert.notNull(r3.getId(), "erro ao criar tarefa c3");
    }

    @Test
    public void listAllTarefa() {
        List<Tarefa> r1 = this.tarefaService.listAll();
        Assert.notNull(r1.size() == 0, "erro ao listar as tarefas");
    }
    
    @Test
    public void findByIdTarefa() {
        Tarefa r1 = this.tarefaService.findById(1);
        Assert.notNull(r1.getId(), "erro ao buscar tarefa");
    }
    
    @Test
    public void updateTarefa() {
    	Tarefa t1 = new Tarefa();
        t1.setStatus(Tarefa.StatusTipo.WORKING);
        t1.setTitulo("Teste 1");
        t1.setDescricao("Teste 1");

        Tarefa r1 = this.tarefaService.update(t1);
        Assert.notNull(r1.getId(), "erro ao atualizar tarefa t1");
    }
    
    @Test
    public void deleteTarefa() {    	
        this.tarefaService.delete(1);
    }
}
