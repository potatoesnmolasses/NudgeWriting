package edu.matc.entity;
import lombok.Data;

/**
 * Represents a webapp writing session
 * @author jgruel
 */
public @Data class TestSession {
    private int wordCount;
    private int sessionLength;
    private int wpm;
    private String goalName;
    private String sessionTitle;
    private DateTime sessionDate;
}