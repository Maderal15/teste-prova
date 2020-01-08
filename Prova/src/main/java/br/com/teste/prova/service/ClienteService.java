package br.com.teste.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.prova.model.Cliente;
import br.com.teste.prova.repository.ClienteRepository;

@Service
public class ClienteService {

	
	private ClienteRepository clienteRepository;
	
	   @Autowired
	    public ClienteService(ClienteRepository clienteRepository){
	        this.clienteRepository = clienteRepository;
	    }
	    
	   
	    public Cliente save(Cliente cliente){
	    	 /*if(cliente.getNumeroCartao() == null){
	         	throw new PaymentNotFoundException("Erro para cadastrar");	
	         }*/

	        return clienteRepository.save(cliente);
	    }
}
