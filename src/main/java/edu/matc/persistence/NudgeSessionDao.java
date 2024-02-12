package edu.matc.persistence;

import edu.matc.entity.NudgeSession;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class NudgeSessionDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get nudgeSession by id
     */
    public NudgeSession getById(int id) {
        Session session = sessionFactory.openSession();
        NudgeSession nudgeSession = session.get(NudgeSession.class, id);
        session.close();
        return nudgeSession;
    }

    /**
     * update nudgeSession
     * @param nudgeSession  NudgeSession to be updated
     */
    public void update(NudgeSession nudgeSession) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(nudgeSession);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new nudgeSession
     * @param nudgeSession  NudgeSession to be inserted
     */
    public int insert(NudgeSession nudgeSession) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(nudgeSession);
        transaction.commit();
        id = nudgeSession.getId();
        session.close();
        return id;
    }

    /**
     * Delete a nudgeSession
     * @param nudgeSession NudgeSession to be deleted
     */
    public void delete(NudgeSession nudgeSession) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(nudgeSession);
        transaction.commit();
        session.close();
    }


    /** Return a list of all sessions
     *
     * @return All sessions
     */
    public List<NudgeSession> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NudgeSession> query = builder.createQuery(NudgeSession.class);
        Root<NudgeSession> root = query.from(NudgeSession.class);
        List<NudgeSession> sessions = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of sessions " + sessions);
        session.close();

        return sessions;
    }

    /**
     * Get nudgeSession by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<NudgeSession> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for nudgeSession with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NudgeSession> query = builder.createQuery(NudgeSession.class);
        Root<NudgeSession> root = query.from(NudgeSession.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<NudgeSession> sessions = session.createSelectionQuery( query ).getResultList();

        session.close();
        return sessions;
    }

    /**
     * Get nudgeSession by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<NudgeSession> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for nudgeSession with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NudgeSession> query = builder.createQuery(NudgeSession.class);
        Root<NudgeSession> root = query.from(NudgeSession.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<NudgeSession> sessions = session.createQuery( query ).getResultList();
        session.close();
        return sessions;
    }

}

