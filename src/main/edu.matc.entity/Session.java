package edu.matc.entity;


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
    private ArrayList<String>;

    /**
     * no argument constructor for the Session object
     */
    public Session() {
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
     * Get session goalName
     * @return goalName the session goal name
     */
    public String getGoalName() {
        return goalName;
    }

    /**
     * set session goal
     * @param goalName the session goals associated
     * potential TODO: depending on future setup of goals, consider making this param a list
     *                 instead, so each session can be a part of multiple goals
     */
    public void setGoalName(String goalName) {
        this.goalName = goalName;
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
    public DateTime getSessionDate() {
        return sessionDate;
    }

    /**
     * set session start date and time
     * @param sessionDate the session date and time
     */
    public void setSessionDate(DateTime sessionDate) {
        this.sessionDate = sessionDate;
    }
}