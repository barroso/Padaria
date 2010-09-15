package br.com.padaria.dao.commons;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T>
{

	public void addEntity(T entity) throws DAOException;

	public void updateEntity(T entity) throws DAOException;

	public void removeEntity(T entity) throws DAOException;

	public List<T> findAll() throws DAOException;

	public T findById(Serializable id) throws DAOException;

}
