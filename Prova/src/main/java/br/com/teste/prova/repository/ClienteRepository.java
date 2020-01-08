package br.com.teste.prova.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.teste.prova.model.Cliente;

@Repository
public class ClienteRepository {
	
	private List<Cliente> clientes;
	
	public ClienteRepository() {
		clientes = new ArrayList<Cliente>();
	}
	
	
    public Cliente save(Cliente cliente){
    	cliente.setId(clientes.size() + 1);
        this.clientes.add(cliente);
        return cliente;
    }


}
