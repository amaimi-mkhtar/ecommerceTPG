package ma.ensa.dao;

import java.io.Serializable;
import java.util.List;

public interface IgenericDao <T extends Serializable>{
	
	   public T findById(int idEntity);
	   public List<T> findAll();
	   public int create(T entity);
	   public T update(T entity);
	   public void delete(T entity);
	   public void deleteById(int idEntity);

}
