package br.com.teste.prova.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime tempoHora;
	private String messagem;
	private String detalhes;

	public ExceptionResponse(LocalDateTime tempoHora, String messagem, String detalhes) {
		super();
		this.tempoHora = tempoHora;
		this.messagem = messagem;
		this.detalhes = detalhes;
	}

	public LocalDateTime getTempoHora() {
		return tempoHora;
	}

	public void setTempoHora(LocalDateTime tempoHora) {
		this.tempoHora = tempoHora;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
