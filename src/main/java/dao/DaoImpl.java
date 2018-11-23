package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Book;
import model.User;

public class DaoImpl {

	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public boolean save(Object o) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean edit(Object o, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from " + o.getClass().toString().substring(12) + " where id=:i");
		query.setParameter("i", id);
		query.executeUpdate();
		session.save(o);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean delete(Object o, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from " + o.getClass().toString().substring(12) + " where id=:i");
		query.setParameter("i", id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public User authenticate(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<User> query = session.createQuery("from User where password=:p");// here persistent class name is Emp
		query.setParameter("p", user.getPassword());
		List<User> list = query.list();
		User granted = (User) list.get(0);
		return granted;
	}

	public Book select(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Book> query = session.createQuery("from Book where id=:i");// here persistent class name is Emp
		query.setParameter("i", id);
		List<Book> list = query.list();
		Book selected = (Book) list.get(0);
		return selected;
	}
}
