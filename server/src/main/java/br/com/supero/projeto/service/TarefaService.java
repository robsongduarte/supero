package br.com.supero.projeto.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.supero.projeto.model.Tarefa;
import br.com.supero.projeto.repository.TarefaRepository;

/**
 * Classe responsável por executar serviços de regras.

 * @author Robson Duarte
 * 

*/
@Service
@Transactional(readOnly = true)
public class TarefaService {
	
	@Autowired
    private TarefaRepository tarefaRepository;
	
	/** Método que retorna uma lista de tarefas

     *   @return List - Tarefas
    */
	public List<Tarefa> listAll() {
        return this.tarefaRepository.findAll();
    }
	
	/** Método que busca e retorna uma tarefas

     *   @return Tarefa
    */
	public Tarefa findById(Integer id) {
        Tarefa tarefa = this.tarefaRepository.findById(id).get();
        Assert.notNull(tarefa, "tarefa não encontrada.");
        return tarefa;
    }
	
	/*
	 * 
	 * * Método que insere uma nova tarefa

    */
	@Transactional()
    public Tarefa create(Tarefa tarefa) throws IllegalArgumentException {
        Assert.notNull(tarefa, "tarefa não pode ser nulo.");
        return this.tarefaRepository.save(tarefa);
    }

	/** Método que atualiza uma tarefa

     *
    */
    @Transactional()
    public Tarefa update(Tarefa tarefa) throws IllegalArgumentException {
        Tarefa c = this.tarefaRepository.findById(tarefa.getId()).get();
        Assert.notNull(c, "Tarefa não encontrado");

        return this.tarefaRepository.save(tarefa);
    }

    /** Método que exclui uma tarefa

     * 
    */
    @Transactional()
    public void delete(@NotNull Integer id) throws IllegalArgumentException {
        this.tarefaRepository.findById(id).ifPresent(this.tarefaRepository::delete);
    }
}
