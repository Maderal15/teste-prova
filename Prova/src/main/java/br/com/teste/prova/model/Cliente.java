package br.com.teste.prova.model;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;

public class Cliente {

	private Integer id;

	@ApiModelProperty(notes = "Nome.")
	private String nome;

	@ApiModelProperty(notes = "Email.")
	private String email;

	@ApiModelProperty(notes = "Data de Nascimento.")
	private LocalDateTime dataDeNascimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDateTime dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
