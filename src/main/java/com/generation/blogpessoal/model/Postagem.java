package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //classe vai se tornar uma entidade do banco de dados
@Table(name="tb_postagens")//nomeando a tabela no banco de dados de tb_postagens
public class Postagem {

	@Id //tornar o campo uma chave primaria no banco de dados
	@GeneratedValue(strategy=GenerationType.IDENTITY)//tornando a chave primaria auto increment
	private Long id;
	
	@NotBlank(message = "O atributo TITULO é obrigatório!")//validation - validar nosso atributo NN e também não vazio
	@Size(min = 5, max = 100, message="O atributo TITULO deve ter no mínimo 5 caracteres e no máximo 100 caracteres.")
	private String titulo;
	
	@NotBlank(message="O atributo TEXTO é obrigatório!")
	@Size(min = 10, max = 1000,  message = "O atributo TEXTO deve ter no mínimo 10 caracteres e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp//pega a data e hora do sistema e preenche no banco de dados
	private LocalDateTime data;
	

	
	//relacionamento
	@ManyToOne //muitas postagens podem pertencer a um tema
	@JsonIgnoreProperties("postagem")//ignorando as postagens na lista de tema, para não ter um loop
	private Tema tema;
	
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	//geramos os getteres and setteres dos atributos para conseguir recuperar e inserir dados nos atributos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
