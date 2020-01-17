package br.com.teste.prova.entity;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ClienteTotal {

	@ApiModelProperty(notes = "Total.")
	private Long total;

	private List<Cliente> clientes;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
