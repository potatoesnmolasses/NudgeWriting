package edu.matc.entity;
import lombok.Data;

/**
 * Represents a webapp writing session
 * @author jgruel
 */
public @Data class Session {
    private int wordCount;
    private int sessionLength;
    private int wpm;
    private String goalName;
    private String sessionTitle;
    private DateTime sessionDate;

    /**
     * no argument constructor for the Session object
     */
    public Session() {
    }


}