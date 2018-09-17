package br.com.supero.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supero.projeto.model.Tarefa;

/**
 * Classe responsável pelos repositório Tarefa.

 * @author Robson Duarte
 * 

*/
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {


}
