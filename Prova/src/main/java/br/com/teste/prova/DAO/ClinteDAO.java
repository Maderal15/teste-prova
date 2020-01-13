package br.com.teste.prova.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.teste.prova.entity.Cliente;
import br.com.teste.prova.util.HibernateUtil;

public class ClinteDAO {

	Transaction transaction = null;

	public Cliente save(Cliente cliente) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return cliente;
	}

	public Cliente findById(Integer id) {
		Cliente cliente = new Cliente();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			cliente = session.get(Cliente.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return cliente;
	}

	public Cliente saveOrUpdate(Integer id, Cliente cliente) {
		Cliente clienteDAO = new Cliente();
		
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            clienteDAO = session.get(Cliente.class, id);
	            
	            if(cliente.getDataDeNascimento() != null) {
	            	clienteDAO.setDataDeNascimento(cliente.getDataDeNascimento());
	            }
	            
	            if(cliente.getEmail() != null && !cliente.getEmail().equals("")) {
	            	clienteDAO.setEmail(cliente.getEmail());
	            }
	            
	            if(cliente.getNome() != null && !cliente.getNome().equals("")) {
	            	clienteDAO.setNome(cliente.getNome());
	            }
	            
	            
	            session.saveOrUpdate(clienteDAO);
	            transaction.commit();
	            session.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
			return clienteDAO;
	    }
}
