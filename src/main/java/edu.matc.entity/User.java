package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.*;

/**
 * Represents a user account and attributes
 * @author jgruel
 */
@Entity
@Table(name = "user")
//TODO to deploy, change database and table name
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NudgeSession> sessions = new ArrayList<>();

    /**
     * no argument constructor
     */
    public User() {
    }

    /**
     * constructor
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param userName the user's username
     */
    public User(String firstName, String lastName, String userName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * get the list of sessions
     * @return sessions the list of sessions
     */
    public List<NudgeSession> getSessions() {
        return sessions;
    }

    /**
     * set the list of sessions
     * @param sessions the list of sessions
     */
    public void setSessions(List<NudgeSession> sessions) {
        this.sessions = sessions;
    }

    /**
     * Add a session to the list of sessions
     * @param session the session to add
     */
    public void addSession(NudgeSession session) {
        sessions.add(session);
        session.setUser(this);
    }

    /**
     * remove a session from the session list
     * @param session the session to remove
     */
    public void removeSession(NudgeSession session) {
        sessions.remove(session);
        session.setUser(null);
    }

    /**
     * get user ID
     * @return id the user ID
     */
    public int getId() {
        return id;
    }

    /**
     * set user ID
     * @param id the user ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get username
     * @return userName the user screen name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set user name
     * @param userName the user screenname
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * get user password
     * @return password the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set user password
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get user first name
     * @return firstName the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set user firstName
     * @param firstName the user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get user last name
     * @return lastName the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set user last name
     * @param lastName the user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get user dob
     * @return dateOfBirth the user date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * set user dob
     * @param dateOfBirth the user's date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
