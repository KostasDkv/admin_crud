package services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MyService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public <T> boolean insert(T t) {

        try {
            em.persist(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public <T> List<T> getAll(Class<T> c) {

        return em.createNamedQuery(c.getSimpleName() + ".findAll", c)
                .getResultList();
    }
}
