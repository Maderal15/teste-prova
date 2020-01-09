package br.com.teste.prova.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import br.com.teste.prova.entity.Cliente;
import br.com.teste.prova.util.HibernateUtil;

@Repository
public class ClienteRepository {
	
	private List<Cliente> clientes;
	
	public ClienteRepository() {
		clientes = new ArrayList<Cliente>();
	}
	
	
    public Cliente save(Cliente cliente){
    	//cliente.setId(clientes.size() + 1);
    	
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            this.clientes.add(cliente);
            session.save(cliente);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
        return cliente;
    }


}
