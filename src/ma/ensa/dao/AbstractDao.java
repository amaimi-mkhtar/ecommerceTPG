package ma.ensa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractDao < T extends Serializable > {
	 
	   protected Class<T> clazz = 
			  (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	   	
	   @Autowired
	   private SessionFactory sessionFactory;
	   	 
	   public SessionFactory getSessionFactory() {
		return sessionFactory;
      }

	   public final void setClazz( Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	 
	   public T findById( int idEntity ){
	      return (T) sessionFactory.getCurrentSession().find(clazz, idEntity );
	   }
	   public List< T > findAll(){
	      return sessionFactory.getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	   }
	 
	   public int create( T entity ){
		   sessionFactory.getCurrentSession().save( entity );
	      return 1;
	   }
	 
	   public T update( T entity ){
		   sessionFactory.getCurrentSession().update( entity );
	      return entity;
	   }
	 
	   public void delete( T entity ){
		   sessionFactory.getCurrentSession().delete( entity );
	   }
	   
	   public void deleteById( int idEntity ) {
	      T entity = findById(idEntity);
	      delete(entity);
	   }
	 
	}

