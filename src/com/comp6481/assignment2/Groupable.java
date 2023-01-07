package com.comp6481.assignment2;

// Assignment 2
// Question: Part II, Question I
// Written by: Mengqi Liu - 40221432
// -----------------------------------------------------

/**
 * Assignment 2<br/>
 * Due Date: 2022.11.27<br/>
 * Mengqi LIU - 40221432<br/>
 */
public interface Groupable {

    /**
     * check if current team object is in the same group with the object t
     * @param t the team object to compare with
     * @return true if current team object is in the same group with the object t. Otherwise, false.
     */
    boolean isInTheGroup(Team t);
}
