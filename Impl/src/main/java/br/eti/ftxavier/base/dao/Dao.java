package br.eti.ftxavier.base.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, ID extends Serializable> {
	
	List<T> findList ( final Integer maxResults, final Integer offset );
	
	void save ( T entity );
	
	void remove ( T entity );
		
	T findById ( ID identifier );

    List<T> findAll ();
    
}
