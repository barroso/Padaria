package br.com.padaria.dao.commons;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CrudDAOJPA<T> implements CrudDAO<T>
{

	private Class<T> classEntity;
	protected static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");

	@SuppressWarnings("unchecked")
	public CrudDAOJPA() {
		this.classEntity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DAOException
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			String query = "from " + classEntity.getSimpleName();
			return manager.createQuery(query).getResultList();
		} catch (Exception e)
		{
			throw new DAOException(e);
		} finally
		{
			if (manager != null)
			{
				manager.close();
			}
		}
	}

	public T findById(Serializable id) throws DAOException
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			return manager.find(classEntity, id);
		} catch (Exception e)
		{
			throw new DAOException(e);
		} finally
		{
			if (manager != null)
			{
				manager.close();
			}
		}
	}

	public void addEntity(T entity) throws DAOException
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			manager.getTransaction().begin();
			manager.persist(entity);
			manager.getTransaction().commit();
		} catch (Exception e)
		{
			manager.getTransaction().rollback();
			throw new DAOException(e);
		} finally
		{
			if (manager != null)
			{
				manager.close();
			}
		}
	}

	public void updateEntity(T entity) throws DAOException
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
		} catch (Exception e)
		{
			manager.getTransaction().rollback();
			throw new DAOException(e);
		} finally
		{
			if (manager != null)
			{
				manager.close();
			}
		}
	}

	public void removeEntity(T entity) throws DAOException
	{
		EntityManager manager = factory.createEntityManager();
		try
		{
			manager.getTransaction().begin();
			entity = manager.merge(entity);
			manager.remove(entity);
			manager.getTransaction().commit();
		} catch (Exception e)
		{
			manager.getTransaction().rollback();
			throw new DAOException(e);
		} finally
		{
			if (manager != null)
			{
				manager.close();
			}
		}
	}

}
