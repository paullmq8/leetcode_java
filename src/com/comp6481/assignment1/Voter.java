package com.comp6481.assignment1;

//________________________________
// Assignment 1
// Mengqi Liu
// Written by: Mengqi Liu 40221432
//________________________________
public class Voter {
    /**
     * Object field definition
     */
    private long voterID;
    private String voterName;
    private byte voterAge;
    private String voterEmail;
    private char[] voterPcode;

    /**
     * Static field definition
     */
    private static int numberOfCreatedVoters;

    /**
     * Static method to return the number of created Voter objects
     * @return the number of created Voter objects
     */
    public static int findNumberOfCreatedVoters() {
        return numberOfCreatedVoters;
    }

    /**
     * Object constructor to instantiate Voter object.
     * Increase the number of created Voter objects when this constructor is called.
     * @param voterID
     * @param voterName
     * @param voterAge
     * @param voterEmail
     * @param voterPcode
     */
    public Voter(long voterID, String voterName, byte voterAge, String voterEmail, char[] voterPcode) {
        this.voterID = voterID;
        this.voterName = voterName;
        this.voterAge = voterAge;
        this.voterEmail = voterEmail;
        this.voterPcode = voterPcode;
        ++numberOfCreatedVoters;
    }

    /**
     * Get voterID.
     * Since after object construction we can't set voterID again,
     * so there's no setter method for voterID field.
     * @return
     */
    public long getVoterID() {
        return voterID;
    }

    /**
     * Set voterName
     * @param voterName
     */
    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    /**
     * Get voterName
     * @return
     */
    public String getVoterName() {
        return voterName;
    }

    /**
     * Set voterAge
     * @param voterAge
     */
    public void setVoterAge(byte voterAge) {
        this.voterAge = voterAge;
    }

    /**
     * Get voterAge
     * @return
     */
    public byte getVoterAge() {
        return voterAge;
    }

    /**
     * Set voterEmail
     * @param voterEmail
     */
    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    /**
     * Get voterEmail
     * @return
     */
    public String getVoterEmail() {
        return voterEmail;
    }

    /**
     * Set voterPcode
     * @param voterPcode
     */
    public void setVoterPcode(char[] voterPcode) {
        this.voterPcode = voterPcode;
    }

    /**
     * Get voterPcode
     * @return
     */
    public char[] getVoterPcode() {
        return voterPcode;
    }

    /**
     * toString method to return readable info about Voter object
     * @return readable info about Voter object
     */
    @Override
    public String toString() {
        return "ID: " + voterID +
               "\nName: " + voterName +
               "\nAge: " + voterAge +
               "\nEmail: " + voterEmail +
               "\nPCode: " + String.valueOf(voterPcode);
    }

    /**
     * Override equals method inherited from Object class to customize the implementation for Voter class.
     * When bothe voterID and voterPcode are the same, the two objects are considered the same.
     * Otherwise they are not the same.
     * @param o another Voter object to compare.
     * @return true if the two Voter objects are the same. false if the two are not the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Voter voter = (Voter) o;

        if (voterID != voter.voterID) return false;

        if (voterPcode.length != voter.voterPcode.length) return false;

        for (int i = 0; i < voterPcode.length; i++) {
            if (voterPcode[i] != voter.voterPcode[i]) return false;
        }
        return true;
    }

    /**
     * Override hashCode method inherited from Object class to customize the implementation for Voter class.
     * This method makes sure different Voter object has different hashcode.
     * @return
     */
    @Override
    public int hashCode() {
        return 17 * Long.valueOf(voterID).hashCode() + 37 * String.valueOf(voterPcode).hashCode();
    }
}
