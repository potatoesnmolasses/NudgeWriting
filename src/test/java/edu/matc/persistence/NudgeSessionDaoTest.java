package edu.matc.persistence;

import edu.matc.entity.NudgeSession;
import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.matc.persistence.Database;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NudgeSessionDaoTest {
    NudgeSessionDao nudgeSession;

    /**
     * set sql instance prior to each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * test the getById() method
     */
    @Test
    void getById() {
        nudgeSession = new NudgeSessionDao();
        NudgeSession retrievedSession = nudgeSession.getById(1);
        assertNotNull(retrievedSession);
        assertEquals("Test", retrievedSession.getSessionTitle());
        assertEquals(2, retrievedSession.getUser().getId());
    }

    /**
     * Test the update() method
     */
    @Test
    void update() {
        nudgeSession = new NudgeSessionDao();
        NudgeSession testSession = nudgeSession.getById(2);
        testSession.setWordCount(1000);
        //update user and retrieve data again
        nudgeSession.update(testSession);
        assertEquals(1000, nudgeSession.getById(2).getWordCount());
    }

    /**
     * test the insert() method
     */
    @Test
    void insertSuccess() {
        nudgeSession = new NudgeSessionDao();
        LocalDateTime now = LocalDateTime.now();

        //get a user
        UserDao userDao = new UserDao();
        User user = userDao.getById(4);
        //create a session under that user
        NudgeSession nudgeSessionToInsert = new NudgeSession(500, 25,
                "Chapter 4", now, user);
        //insert the session
        int insertSessionId = nudgeSession.insert(nudgeSessionToInsert);
        //retrieve the session
        NudgeSession retrievedSession = nudgeSession.getById(insertSessionId);
        //verify
        assertNotNull(retrievedSession);
        assertEquals(nudgeSessionToInsert.getSessionTitle(), retrievedSession.getSessionTitle());
        assertEquals("Dianne", retrievedSession.getUser().getFirstName());
    }

    /**
     * test the delete() method
     */
    @Test
    void delete() {
        nudgeSession = new NudgeSessionDao();
        NudgeSession retrievedSession = nudgeSession.getById(1);
        nudgeSession.delete(retrievedSession);
        assertNull(nudgeSession.getById(1));
    }



    /**
     * test the getAll() method
     */
    @Test
    void getAll() {
        nudgeSession = new NudgeSessionDao();
        List<NudgeSession> sessions = nudgeSession.getAll();
        assertEquals(3, sessions.size());
    }

    /**
     * Tests the getByPropertyEqual() method
     */
    @Test
    void getByPropertyEqual() {
        nudgeSession = new NudgeSessionDao();
        List<NudgeSession> sessions = nudgeSession.getByPropertyLike("sessionTitle", "Test2");
        assertEquals(1, sessions.size());
        assertEquals(2, sessions.get(0).getId());
    }


    /**
     * Tests the getByPropertyLike() method
     */
    @Test
    void getByPropertyLike() {
        nudgeSession = new NudgeSessionDao();
        List<NudgeSession> sessions = nudgeSession.getByPropertyLike("sessionTitle", "T");
        assertEquals(2, sessions.size());
    }
}