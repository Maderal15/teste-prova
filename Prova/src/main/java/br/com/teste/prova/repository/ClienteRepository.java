package br.com.teste.prova.repository;

import org.springframework.stereotype.Repository;

import br.com.teste.prova.DAO.ClinteDAO;
import br.com.teste.prova.entity.Cliente;

@Repository
public class ClienteRepository {


	public ClienteRepository() {
	}

	public Cliente save(Cliente cliente) {
		ClinteDAO dao = new ClinteDAO();
		dao.save(cliente);
		return cliente;
	}

	public Cliente findById(Integer id) {
		ClinteDAO dao = new ClinteDAO();
	 	return dao.findById(id);

	}
}
