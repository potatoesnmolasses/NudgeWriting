package edu.matc.persistence;

import edu.matc.entity.NudgeSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.matc.persistence.Database;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NudgeSessionDaoTest {
    NudgeSessionDao nudgeSession;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }
    @Test
    void getById() {
        nudgeSession = new NudgeSessionDao();
        NudgeSession retrievedSession = nudgeSession.getById(1);
        assertNotNull(retrievedSession);
        assertEquals("Test", retrievedSession.getSessionTitle());
    }

    @Test
    void update() {
        nudgeSession = new NudgeSessionDao();
        LocalDateTime now = LocalDateTime.now();
        NudgeSession testSession = new NudgeSession(500, 25,
                20, "Test2", now);
    }

    @Test
    void insertSuccess() {
        nudgeSession = new NudgeSessionDao();
        LocalDateTime now = LocalDateTime.now();
        NudgeSession testSession = new NudgeSession(500, 25,
                20, "Test2", now);

        int insertedSessionID = nudgeSession.insert(testSession);
        assertNotEquals(0, insertedSessionID);
        NudgeSession sessionToInsert = nudgeSession.getById(insertedSessionID);
        assertEquals("Test2", sessionToInsert.getSessionTitle());
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}