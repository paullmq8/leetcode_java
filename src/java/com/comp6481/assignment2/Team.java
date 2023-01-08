package com.comp6481.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Assignment 2
// Question: Part II, Question II
// Written by: Mengqi Liu - 40221432
// -----------------------------------------------------

/**
 * Assignment 2<br/>
 * Due Date: 2022.11.27<br/>
 * Mengqi LIU - 40221432<br/>
 */
public class Team implements Groupable, Cloneable {

    /**
     * the prefix length for teamID field. The prefix is GROUPX, X shows the group letter.
     */
    public static final int TEAMID_PREFIX_LENGTH = 6;

    private String teamID; // unique
    private String teamName;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private double netRunRate;
    private int points;

    /**
     * Constructor for class Team with specific data
     * @param teamID team id
     * @param teamName team name
     * @param gamesPlayed the game number played by the team
     * @param gamesWon the won game number played by the team
     * @param gamesLost the lost game number played by the team
     * @param netRunRate the net run rate for the team
     * @param points the points calculated based on all the game numbers.
     */
    public Team(String teamID, String teamName, int gamesPlayed, int gamesWon,
                int gamesLost, double netRunRate, int points) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.netRunRate = netRunRate;
        this.points = points;

        List<Integer> list = new ArrayList<>();
        list.stream().reduce(0, (x, y) -> x + y);
    }

    /**
     * Constructor for class Team with another Team object and designated team id
     * @param t another Team object to copy field data from
     * @param id the designated team id
     */
    public Team(Team t, String id) {
        teamID = id;
        teamName = t.getTeamName();
        gamesPlayed = t.getGamesPlayed();
        gamesWon = t.getGamesWon();
        gamesLost = t.getGamesLost();
        netRunRate = t.getNetRunRate();
        points = t.getPoints();

        StringBuffer sb = new StringBuffer();
        sb.append("aa").append(1);
        String res = "";
    }

    /**
     * implementation of clone() method ovrriding Object.clone() method
     * @return
     */
    @Override
    public Team clone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a new teamID");
        String id = scanner.nextLine();
        return new Team(this, id);
    }

    /**
     * display readable text of Team object
     * @return readable text of Team object
     */
    @Override
    public String toString() {
        return "Team{" +
                "teamID='" + teamID + '\'' +
                ", teamName='" + teamName + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesWon=" + gamesWon +
                ", gamesLost=" + gamesLost +
                ", netRunRate=" + netRunRate +
                ", points=" + points +
                '}';
    }

    /**
     * check if two objects of class Team are the same.
     * @param o another comparing Team object
     * @return true if two objects of class Team are the same. Otherwise, false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (gamesPlayed != team.gamesPlayed) return false;
        if (gamesWon != team.gamesWon) return false;
        if (gamesLost != team.gamesLost) return false;
        if (Double.compare(team.netRunRate, netRunRate) != 0) return false;
        if (points != team.points) return false;
        return Objects.equals(teamName, team.teamName);
    }

    /**
     * returns hash code of Team object
     * @return hash code of Team object
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = teamName != null ? teamName.hashCode() : 0;
        result = 31 * result + gamesPlayed;
        result = 31 * result + gamesWon;
        result = 31 * result + gamesLost;
        temp = Double.doubleToLongBits(netRunRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + points;
        return result;
    }

    /**
     * check if current team object is in the same group with the object t.
     * the criteria is based on the prefix of teamID field. If they have the same prefix, then they're in the same group.
     * @param t the team object to compare with
     * @return true if current team object is in the same group with the object t. Otherwise, false.
     */
    @Override
    public boolean isInTheGroup(Team t) {
        return this.teamID.substring(0, TEAMID_PREFIX_LENGTH).equals(t.teamID.substring(0, TEAMID_PREFIX_LENGTH));
    }

    /**
     * method of getting teamID
     * @return teamID value in String
     */
    public String getTeamID() {
        return teamID;
    }

    /**
     * method of setting teamID
     * @param teamID teamID value to be set
     */
    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    /**
     * method of getting teamName
     * @return teamName in String
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * method of setting teamName
     * @param teamName teamName value to be set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * method of getting gamesPlayed
     * @return gamesPlayed value in integer
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * method of setting gamesPlayed
     * @param gamesPlayed gamesPlayed value to be set
     */
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * method of getting gamesWon
     * @return gamesWon value in integer
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * method of setting gamesWon
     * @param gamesWon gamesWon to be set
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    /**
     * method of getting gamesLost
     * @return gamesLost in integer
     */
    public int getGamesLost() {
        return gamesLost;
    }

    /**
     * method of setting gamesLost
     * @param gamesLost gamesLost value to be set
     */
    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    /**
     * method of getting netRunRate
     * @return netRunRate in double precision
     */
    public double getNetRunRate() {
        return netRunRate;
    }

    /**
     * method of setting netRunRate
     * @param netRunRate the netRunRate to be set
     */
    public void setNetRunRate(double netRunRate) {
        this.netRunRate = netRunRate;
    }

    /**
     * method of getting points
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * method of setting points
     * @return void
     */
    public void setPoints(int points) {
        this.points = points;
    }
}
