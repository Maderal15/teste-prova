package br.com.teste.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.prova.entity.Cliente;
import br.com.teste.prova.entity.ClienteTotal;
import br.com.teste.prova.exception.ClienteNotFoundException;
import br.com.teste.prova.repository.ClienteRepository;

@Service
public class ClienteService {

	
	private ClienteRepository clienteRepository;
	
	   @Autowired
	    public ClienteService(ClienteRepository clienteRepository){
	        this.clienteRepository = clienteRepository;
	    }
	    
	   
	    public Cliente save(Cliente cliente){
	    	 if(cliente == null){
	         	throw new ClienteNotFoundException("Erro para cadastrar");	
	         }

	        return clienteRepository.save(cliente);
	    }
	    
	    public Cliente findById(Integer id) {
	    	Cliente cliente =  clienteRepository.findById(id);
	    	
	    	if(cliente == null) {
	    		throw new ClienteNotFoundException("Id não encontrado");	
	    	}
	        return cliente;
	    }
	    
	    public Cliente update(Integer id, Cliente cliente) {
	    	cliente = clienteRepository.update(id, cliente);
	    	if(cliente == null) {
	    		throw new ClienteNotFoundException("Id não encontrado");	
	    	}
	        return cliente;
	    }
	    
	    public Cliente delete(Integer id){
	    	Cliente cliente = clienteRepository.delete(id);
	     	
	    	if(cliente == null) {
	    		throw new ClienteNotFoundException("Id não encontrado");	
	    	}
	        return cliente;
	    }
	    
	    public ClienteTotal listCliente(Integer limite, Integer pagina) {
	    	if(limite == null) {
	    		throw new ClienteNotFoundException("Limite obrigatório");
	    		
	    	}
	    	
	    	if(pagina == null) {
	    		throw new ClienteNotFoundException("Página obrigatório");
	    		
	    	}
	        return clienteRepository.listCliente(limite, pagina);
	    }

}


