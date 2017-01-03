package DAO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita Philippov on 02.01.17.
 */
public abstract class AbstractDAO<E, K> {

    public abstract E getEntityById(Long id);
    public abstract Collection<E> getAllEntities();

    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);


}
