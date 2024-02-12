package edu.matc.entity;

/**
 * Represents a webapp writing session
 * @author jgruel
 */
public class TestSessionDriver {

    public static void main(String[] args) {
        TestSession myTest = new TestSession();
        myTest.setWordCount(12);
        System.out.println(myTest.getWordCount());
    }

}