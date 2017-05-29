package fitec.com.service;

import java.util.List;

public interface IMetier<T> {

	public T add(T object);
	public T find(Integer id);
	public T update(T object);
	public void delete(Integer id);
	public List<T> findAll();
	
	
}
