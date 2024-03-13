package edu.matc.persistence;

import edu.matc.entity.NudgeSession;
import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserDaoTest {
    UserDao userDao;
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());

    }

    @Test
    void updateSuccess() {
        userDao = new UserDao();
        User userToUpdate = (User)genericDao.getById(1);
        userToUpdate.setLastName("Smith");
        genericDao.update(userToUpdate);

        // retrieve the user and check that the name change worked
        User actualUser = (User)genericDao.getById(1);
        assertEquals("Smith", actualUser.getLastName());

    }

    @Test
    void insertSuccess() {
        userDao = new UserDao();
        User userToInsert = new User("Kia", "Yang", "ky001");
        int insertedUserId = userDao.insert(userToInsert);
        assertNotEquals(0, insertedUserId);
        User insertedUser = userDao.getById(insertedUserId);
        assertEquals("Kia", insertedUser.getFirstName());

    }

    @Test
    void addSession() {
        LocalDateTime now = LocalDateTime.now();
        NudgeSession nudge = new NudgeSession(1500, 45, "summary", now);
        User retrievedUser = (User)genericDao.getById(2);
        retrievedUser.addSession(nudge);

        List<NudgeSession> sessionList = retrievedUser.getSessionList();
        assertEquals(2, sessionList.size());
    }

    @Test
    void deleteSession() {
        User user = (User)genericDao.getById(1);
        List <NudgeSession> sessionList = user.getSessionList();
        NudgeSession nudgeToDelete = sessionList.get(0);
        user.removeSession(nudgeToDelete);
        List <NudgeSession> testList = user.getSessionList();

        assertEquals(0, testList.size());

    }

    @Test
    void delete() {
        User user = (User)genericDao.getById(3);
        genericDao.delete(user);
        assertNull(genericDao.getById(3));
    }

    @Test
    void deleteWithSessions() {
        //Get user and sessions from user
        User userToDelete = (User)genericDao.getById(3);
        List<NudgeSession> sessionList = userToDelete.getSessionList();
        int sessionNumber = sessionList.get(0).getId();
        //Delete user
        genericDao.delete(userToDelete);
        assertNull(genericDao.getById(3));
        //verify
        GenericDao sessionDao = new GenericDao(NudgeSession.class);
        assertNull(sessionDao.getById(2));

    }

    @Test
    void getAll() {
        userDao = new UserDao();
        List<User> users = userDao.getAll();
        assertEquals(5, users.size());
    }

    @Test
    void getByPropertyEqual() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        userDao = new UserDao();
        List<User> users = userDao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }

}
