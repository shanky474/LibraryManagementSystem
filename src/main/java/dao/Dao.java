package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

public interface Dao {

	public boolean save(Object o);

	public boolean edit(Object o, int id);

	public boolean delete(Object o, int id);

}
