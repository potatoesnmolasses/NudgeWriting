package edu.matc.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

/**
 * Represents a webapp writing session
 * @author jgruel
 */
@Data
@Entity(name = "NudgeSession")
@Table(name = "session_test")
//TODO to deploy, change database and table name
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
   //TODO "tag" the session with a goal/goals. private String goalName;
    @Column(name = "title")
    private String sessionTitle;
    @Column(name = "session_date")
    private LocalDateTime sessionDate;
    @ManyToOne
    private User user;


    /**
     * NudgeSession constructor with all parameters
     * @param wordCount the word count
     * @param sessionLength the session length in minutes
     * @param sessionTitle the title of the session
     * @param sessionDate the date and time of the session
     * @param user the user
     */
    public NudgeSession(int wordCount, int sessionLength, String sessionTitle, LocalDateTime sessionDate, User user) {
        this.wordCount = wordCount;
        this.sessionLength = sessionLength;
        calculateWpm(sessionLength, wordCount);
        this.sessionTitle = sessionTitle;
        this.sessionDate = sessionDate;
        this.user = user;
    }
    //TODO: multiple goals per session? private ArrayList<String>;

    /**
     * NudgeSession constructor with all parameters
     * @param wordCount the word count
     * @param sessionLength the session length in minutes
     * @param sessionTitle the title of the session
     * @param sessionDate the date and time of the session
     */
    public NudgeSession(int wordCount, int sessionLength, String sessionTitle, LocalDateTime sessionDate) {
        this.wordCount = wordCount;
        this.sessionLength = sessionLength;
        calculateWpm(sessionLength, wordCount);
        this.sessionTitle = sessionTitle;
        this.sessionDate = sessionDate;
    }

    /**
     * get user
     * @return user the user
     */
    public User getUser() {
        return user;
    }

    /**
     * set user
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

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
     * set session word count
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

    /**
     * calculate the words per minute for the session
     * @param sessionLength the length of the session in minutes
     * @param wordCount the words produced in the session
     */
    public void calculateWpm(int sessionLength, int wordCount) {
        this.wpm = wordCount / sessionLength;
    }
}