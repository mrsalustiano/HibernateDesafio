package com.qintess.DesafioHibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.DesafioHibernate.Config.HibernateConfig;
import com.qintess.DesafioHibernate.Model.InterfaceModel;

public class GenericDAO<T extends InterfaceModel> {

	public void salvar(T objeto) {
		Transaction transacao = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transacao = session.beginTransaction();
			if (objeto.getId() == 0) {
				session.save(objeto);
			} else {
				session.merge(objeto);
			}

			transacao.commit();
			session.close();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			e.printStackTrace();
		}
		
	}


	public List<T> listaTodos(Class<T> clazz){
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		return (List<T>) session.createQuery("select t from " + clazz.getName() + " t").getResultList();

	}
	
	public T buscaPorId(Class<T> clazz, int id) {

		Session session = HibernateConfig.getSessionFactory().openSession();
		return session.find(clazz, id);

	}
	
	public void remove(Class<T> clazz, int id){
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		T t = buscaPorId(clazz, id);
		try{
			session.getTransaction().begin();
			session.remove(t);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}
