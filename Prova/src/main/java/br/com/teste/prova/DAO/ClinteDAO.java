package br.com.teste.prova.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.teste.prova.entity.Cliente;
import br.com.teste.prova.entity.ClienteTotal;
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
			
			if(clienteDAO == null) {
				return null;
			}

			if (cliente.getDataDeNascimento() != null) {
				clienteDAO.setDataDeNascimento(cliente.getDataDeNascimento());
			}

			if (cliente.getEmail() != null && !cliente.getEmail().equals("")) {
				clienteDAO.setEmail(cliente.getEmail());
			}

			if (cliente.getNome() != null && !cliente.getNome().equals("")) {
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

	public Cliente delete(Integer id) {
		Cliente cliente = new Cliente();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			cliente = session.get(Cliente.class, id);
			if (cliente != null) {
				session.delete(cliente);
			}

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
	
	public ClienteTotal getCliente(Integer limite, Integer pagina) {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteTotal clienteTotal = new ClienteTotal();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM Cliente";
            Query query = session.createQuery(hql);
            query.setFirstResult(pagina);
            query.setMaxResults(limite);
            clientes = query.getResultList();
            clienteTotal.setClientes(clientes);  
            
            String hqlCount = " select count(*)  from Cliente";
            Query queryCount = session.createQuery(hqlCount);
            Long total = (Long) queryCount.uniqueResult();
            clienteTotal.setTotal(total);
            
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return clienteTotal;
    }
}
