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
}
