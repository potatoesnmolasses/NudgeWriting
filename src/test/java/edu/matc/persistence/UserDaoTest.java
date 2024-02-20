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

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }
    @Test
    void getByIdSuccess() {
        userDao = new UserDao();
        User retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());

    }

    @Test
    void updateSuccess() {
        userDao = new UserDao();
        User userToUpdate = userDao.getById(1);
        userToUpdate.setLastName("Smith");
        userDao.update(userToUpdate);

        // retrieve the user and check that the name change worked
        User actualUser = userDao.getById(1);
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
        userDao = new UserDao();
        LocalDateTime now = LocalDateTime.now();
        NudgeSession nudge = new NudgeSession(1500, 45, "summary", now);
        User retrievedUser = userDao.getById(2);
        retrievedUser.addSession(nudge);

        List<NudgeSession> sessionList = retrievedUser.getSessionList();
        assertEquals(2, sessionList.size());
    }

    @Test
    void deleteSession() {
        userDao = new UserDao();
        User user = userDao.getById(1);
        List <NudgeSession> sessionList = user.getSessionList();
        NudgeSession nudgeToDelete = sessionList.get(0);
        //userDao.getById(1).removeSession(nudgeToDelete);
        user.removeSession(nudgeToDelete);
        List <NudgeSession> testList = user.getSessionList();

        assertEquals(0, testList.size());

    }

    @Test
    void delete() {
        userDao = new UserDao();
        userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));
    }

    @Test
    void deleteWithSessions() {
        userDao = new UserDao();
        //Get user and sessions from user
        User userToDelete = userDao.getById(3);
        List<NudgeSession> sessionList = userToDelete.getSessionList();
        int sessionNumber = sessionList.get(0).getId();
        //Delete user
        userDao.delete(userToDelete);
        assertNull(userDao.getById(3));
        //verify
        NudgeSessionDao sessionDao = new NudgeSessionDao();
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
