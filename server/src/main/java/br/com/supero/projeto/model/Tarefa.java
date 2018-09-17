package br.com.supero.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para objetos do tipo Tarefas, onde serão contidos, valores e métodos para o mesmo.

 * @author Robson Duarte
 * 

*/
@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTipo status;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public StatusTipo getStatus() {
		return status;
	}

	public void setStatus(StatusTipo status) {
		this.status = status;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public enum StatusTipo {
		TODO,WORKING,DONE
    }

}
