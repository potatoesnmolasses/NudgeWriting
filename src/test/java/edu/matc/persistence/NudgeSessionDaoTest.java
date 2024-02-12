package edu.matc.persistence;

import edu.matc.entity.NudgeSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NudgeSessionDaoTest {
    NudgeSessionDao nudgeSession;
    @Test
    void getById() {
        nudgeSession = new NudgeSessionDao();
        NudgeSession retrievedSession = nudgeSession.getById(1);
        assertNotNull(retrievedSession);
        assertEquals("Test", retrievedSession.getSessionTitle());
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
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