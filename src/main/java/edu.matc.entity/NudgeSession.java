package edu.matc.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

/**
 * Represents a webapp writing session
 * @author jgruel
 */
@Entity
@Table(name = "session")
public class NudgeSession {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @Column(name = "word_count")
    private int wordCount;
    @Column(name = "length")
    private int sessionLength;
    @Column(name = "wpm")
    private int wpm;
   //TODO private String goalName;
    @Column(name = "title")
    private String sessionTitle;
    @Column(name = "session_date")
    private LocalDateTime sessionDate;

    /**
     * NudgeSession constructor with all parameters
     * @param wordCount the word count
     * @param sessionLength the session length in minutes
     * @param wpm the words per minute
     * @param sessionTitle the title of the session
     * @param sessionDate the date and time of the session
     */
    public NudgeSession(int wordCount, int sessionLength, int wpm, String sessionTitle, LocalDateTime sessionDate) {
        this.wordCount = wordCount;
        this.sessionLength = sessionLength;
        this.wpm = wpm;
        this.sessionTitle = sessionTitle;
        this.sessionDate = sessionDate;
    }
    //TODO: multiple goals per session? private ArrayList<String>;

    /**
     * get ID
     * @return id session ID
     */
    public int getId() {
        return id;
    }

    /**
     * set ID
     * @param id session id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * no argument constructor for the Session object
     */
    public NudgeSession() {
    }

    /**
     * Get session wordcount
     * @return wordCount the session wordcount
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * set session wordcount
     * @param wordCount the session wordcount
     */
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * Get session duration length in minutes
     * @return sessionLength the session length
     */
    public int getSessionLength() {
        return sessionLength;
    }

    /**
     * set session length
     * @param sessionLength the session length
     */
    public void setSessionLength(int sessionLength) {
        this.sessionLength = sessionLength;
    }

    /**
     * Get session wpm
     * @return wpm the overall session words per minute
     */
    public int getWpm() {
        return wpm;
    }

    /**
     * set session wpm speed
     * @param wpm the session words per minute
     */
    public void setWpm(int wpm) {
        this.wpm = wpm;
    }


    /**
     * Get session wordcount
     * @return wordCount the session wordcount
     */
    public String getSessionTitle() {
        return sessionTitle;
    }

    /**
     * set session title
     * @param sessionTitle the session title
     */
    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    /**
     * Get session start datetime
     * @return sessionDate the session date and time
     */
    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    /**
     * set session start date and time
     * @param sessionDate the session date and time
     */
    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }
}