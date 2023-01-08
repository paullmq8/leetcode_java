package com.comp6481.assignment2;

import com.comp6481.assignment2.TeamList.TeamNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Input:
GROUPA
ENGLAND 5 4 1 2.464 8
AUSTRALIA 5 4 1 1.216 8
SOUTH_AFRICA 5 4 1 0.739 8
SRI_LANKA 5 2 3 .269 4
WEST_INDIES 5 1 4 -1.641 2
BANGLADESH 5 0 5 -2.383 0

GROUPB
PAKISTAN 5 5 0 1.583 10
NEW_ZEALAND 5 4 1 1.162 8
INDIA 5 3 2 1.747 6
AFGHANISTAN 5 2 3 1.053 4
NAMIBIA 5 1 4 -1.890 2
SCOTLAND 5 0 5 -3.543 0

Request:
AUSTRALIA
NEW_ZEALAND
NAMIBIA
SOUTH_AFRICA
 */


// Assignment 2
// Question: Part II, Question IV
// Written by: Mengqi Liu - 40221432
// -----------------------------------------------------

/**
 * Assignment 2<br/>
 * Due Date: 2022.11.27<br/>
 * Mengqi LIU - 40221432<br/>
 */
public class TournamentResults {

    private static final int TEAM_NUMBER_IN_GROUP = 6;
    private static final String QUALIFIES_WITH_HIGHEST_POINTS = " qualifies for the second round as it has more points than four other teams.";
    private static final String QUALIFIES_WITH_HIGHER_RUN_RATE = " qualifies for the second round as it has a higher net run rate.";
    private static final String NOT_QUALIFY_WITH_NOT_ENOUGH_POINTS = " can’t qualify for the second round as it doesn’t have enough points.";
    private static final String NOT_QUALIFY_WITH_NOT_ENOUGH_RUN_RATE = " can't qualify for the second round as it doesn't have high enough run rate.";
    private static final String NO_SUCH_TEAM = "No such team";

    private static int teamID = 1;

    /**
     * allow user to input Group data for two team lists.
     * @param scanner the current scanner
     * @param teamLists the two teamLists to enter into
     * @param groupName the groupName to be input
     */
    private static void inputGroupData(Scanner scanner, List<TeamList> teamLists, String groupName) {
        TeamList teamList = new TeamList();
        System.out.println(groupName);
        List<Team> list = new ArrayList<>();
        for (int i = 1; i <= TEAM_NUMBER_IN_GROUP; i++) {
            String[] data = scanner.nextLine().split(" ");
            Team team = new Team(groupName + teamID, data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]), Double.parseDouble(data[4]), Integer.parseInt(data[5]));
            teamList.addToStart(team);
            list.add(team);
            teamID++;
        }
        list.stream().sorted(Comparator.comparingInt(Team::getPoints).reversed());
        teamList.getHighestTwoPoints().add(list.get(0).getPoints());
        teamList.getHighestTwoPoints().add(list.get(1).getPoints());

        list.stream().sorted(Comparator.comparingDouble(Team::getNetRunRate).reversed());
        teamList.getHighestTwoNetRunRates().add(list.get(0).getNetRunRate());
        teamList.getHighestTwoNetRunRates().add(list.get(1).getNetRunRate());
        teamLists.add(teamList);
    }

    /**
     * method to determine if the team teamName can move into the next round.
     * @param teamLists the two groups to be checked with
     * @param teamName the team to be checked
     * @return the result for the team.
     */
    private static String ifMoveIntoNextRound(List<TeamList> teamLists, String teamName) {
        for (TeamList teamList : teamLists) {
            TeamList.TeamNode teamNode = teamList.findByTeamName(teamName);
            if (teamNode != null) {
                Team team = teamNode.getTeam();
                int points = team.getPoints();
                double netRunRate = team.getNetRunRate();
                List<Integer> highestPoints = teamList.getHighestTwoPoints();
                List<Double> highestNetRunRates = teamList.getHighestTwoNetRunRates();
                if ((points == highestPoints.get(0) || points == highestPoints.get(1)) && highestPoints.get(0) > highestPoints.get(1)) {
                    return QUALIFIES_WITH_HIGHEST_POINTS;
                } else if (points == highestPoints.get(0) && points == highestPoints.get(1) && netRunRate >= highestNetRunRates.get(1)) {
                    return QUALIFIES_WITH_HIGHER_RUN_RATE;
                } else if (points < highestPoints.get(1)) {
                    return NOT_QUALIFY_WITH_NOT_ENOUGH_POINTS;
                } else if (points == highestPoints.get(0) && points == highestPoints.get(1) && netRunRate < highestNetRunRates.get(1)) {
                    return NOT_QUALIFY_WITH_NOT_ENOUGH_RUN_RATE;
                }
            }
        }
        return NO_SUCH_TEAM;
    }

    /**
     * main method for the TournamentResult program.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Tournament System! Mengqi Liu\n");

        Scanner scanner = new Scanner(System.in);

        List<TeamList> teamLists = new ArrayList<>();
        String groupA = "GROUPA", groupB = "GROUPB";
        System.out.println("Please enter two group info. Each data separated by one blank space:");
        inputGroupData(scanner, teamLists, groupA);
        inputGroupData(scanner, teamLists, groupB);

        System.out.println("Please enter your request. Enter exit to quit:");
        while (true) {
            String request = scanner.nextLine();
            if ("exit".equalsIgnoreCase(request)) break;
            System.out.println(request + ifMoveIntoNextRound(teamLists, request));
        }

        System.out.println("\n========================Here are all the teams info========================\n");
        System.out.println(groupA);
        TeamNode node = teamLists.get(0).getHead();
        while (node != null) {
            System.out.println(node.getTeam());
            node = node.getNext();
        }
        System.out.println(groupB);
        node = teamLists.get(1).getHead();
        while (node != null) {
            System.out.println(node.getTeam());
            node = node.getNext();
        }
        System.out.println("\n============================================================================\n");

        System.out.println("\n==========Now you can search for a few teamIDs in both team lists. Enter exit to quit==========\n");
        while (true) {
            String teamID = scanner.nextLine();
            if ("exit".equalsIgnoreCase(teamID)) break;
            boolean found = false;
            for (TeamList teamList : teamLists) {
                TeamNode teamNode = teamList.findAndPrintIteration(teamID);
                if (teamNode != null) {
                    System.out.println(teamNode.getTeam());
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Team " + teamID + " is not found.");
        }
        System.out.println("\n============================================================================\n");


        System.out.println("\n========================testing all constructors, clone() and isInTheGroup() for class Team=======================\n");
        // test all constructors
        Team teamA1 = new Team("GROUPA1", "team A1", 5, 4, 3, 2.3, 8);
        Team teamA2 = new Team("GROUPA2", "team A2", 5, 3, 4, 1.2, 5);
        Team teamB1 = new Team("GROUPB1", "team B1", 5, 3, 4, 1.2, 5);

        Team teamA3 = new Team(teamA1, "GROUPA3");
        System.out.println("teamA3 is deep copied by constructor new Team(teamObj, teamID)");
        System.out.println(teamA1);
        System.out.println(teamA3);
        System.out.println("teamA1.equals(teamA3)? " + teamA1.equals(teamA3));
        teamA3.setGamesWon(6);
        System.out.println("teamA3.setGamesWon(6)");
        System.out.println(teamA1);
        System.out.println(teamA3);
        System.out.println("teamA1.equals(teamA3)? " + teamA1.equals(teamA3));

        System.out.println("\n=================================================================================================================\n");

        Team teamX = teamA1.clone(); //GROUPA4
        System.out.println(teamX.getTeamID() + " is cloned from teamA1.");
        System.out.println(teamA1);
        System.out.println(teamX);
        System.out.println("teamA1.equals(" + teamX.getTeamID() + ")? " + teamA1.equals(teamX));
        teamX.setGamesWon(6);
        System.out.println(teamX.getTeamID() + ".setGamesWon(6)");
        System.out.println(teamA1);
        System.out.println(teamX);
        System.out.println("teamA1.equals(" + teamX.getTeamID() + ")? " + teamA1.equals(teamX));

        System.out.println("\n=================================================================================================================\n");


        // test isInTheGroup()
        System.out.println("teamA1.isInTheGroup(teamA2)? " + teamA1.isInTheGroup(teamA2));
        System.out.println("teamB1.isInTheGroup(teamA2)? " + teamB1.isInTheGroup(teamA2));

        System.out.println("\n==========================testing all constructors and clone() for class TeamList.TeamNode=========================\n");

        Team teamA5 = new Team("GROUPA5", "team A5", 5, 4, 3, 2.3, 8);
        Team teamA6 = new Team("GROUPA6", "team A6", 5, 4, 3, 2.3, 8);
        Team teamA7 = new Team("GROUPA7", "team A7", 5, 4, 3, 2.3, 8);
        TeamList.TeamNode teamNodeA7 = new TeamList.TeamNode(teamA7, null);
        TeamList.TeamNode teamNodeA6 = new TeamList.TeamNode(teamA6, teamNodeA7);
        TeamList.TeamNode teamNodeA5 = new TeamList.TeamNode(teamA5, teamNodeA6);
        System.out.println("Using copy constructor of TeamList.TeamNode to deep copy and construct copiedTeamNode from teamNodeA5");
        TeamList.TeamNode copiedTeamNode = new TeamList.TeamNode(teamNodeA5);
        System.out.println("\n===================printing teamNodeA5===================\n");
        node = teamNodeA5;
        while (node != null) {
            System.out.println(node.getTeam());
            node = node.getNext();
        }
        System.out.println("\n===================printing copiedTeamNode from teamNodeA5===================\n");
        node = copiedTeamNode;
        while (node != null) {
            System.out.println(node.getTeam());
            node = node.getNext();
        }
        System.out.println("copiedTeamNode == teamNodeA5? "
                + (copiedTeamNode == teamNodeA5));
        System.out.println("copiedTeamNode.getNext() == teamNodeA5.getNext()? "
                + (copiedTeamNode.getNext() == teamNodeA5.getNext()));
        System.out.println("copiedTeamNode.getNext().getNext() == teamNodeA5.getNext().getNext()? "
                + (copiedTeamNode.getNext().getNext() == teamNodeA5.getNext().getNext()));
        System.out.println("\n=================================================================================================================\n");

        System.out.println("Using clone() of TeamList.TeamNode to deep copy and construct copiedTeamNode2 from teamNodeA5");
        TeamList.TeamNode copiedTeamNode2 = new TeamList.TeamNode(teamNodeA5);
        System.out.println("\n===================printing teamNodeA5===================\n");
        node = teamNodeA5;
        while (node != null) {
            System.out.println(node.getTeam());
            node = node.getNext();
        }
        System.out.println("\n===================printing copiedTeamNode2 from teamNodeA5===================\n");
        node = copiedTeamNode2;
        while (node != null) {
            System.out.println(node.getTeam());
            node = node.getNext();
        }
        System.out.println("copiedTeamNode2 == teamNodeA5? "
                + (copiedTeamNode2 == teamNodeA5));
        System.out.println("copiedTeamNode2.getNext() == teamNodeA5.getNext()? "
                + (copiedTeamNode2.getNext() == teamNodeA5.getNext()));
        System.out.println("copiedTeamNode2.getNext().getNext() == teamNodeA5.getNext().getNext()? "
                + (copiedTeamNode2.getNext().getNext() == teamNodeA5.getNext().getNext()));
        System.out.println("\n=================================================================================================================\n");

        System.out.println("Using copy constructor of TeamList to deep copy and construct copiedTeamNode from teamNodeA5");
        TeamList teamList = new TeamList(teamNodeA5, 3);
        TeamList copiedTeamList = new TeamList(teamList);
        System.out.println("teamList == copiedTeamList? " + (teamList == copiedTeamList));
        System.out.println("teamList.getHead() == copiedTeamList.getHead()? "
                + (teamList.getHead() == copiedTeamList.getHead()));
        System.out.println("teamList.getHead().getNext() == copiedTeamList.getHead().getNext()? "
                + (teamList.getHead().getNext() == copiedTeamList.getHead().getNext()));
        System.out.println("teamList.getHead().getNext().getNext() == copiedTeamList.getHead().getNext().getNext()? "
                + (teamList.getHead().getNext().getNext() == copiedTeamList.getHead().getNext().getNext()));
        System.out.println("\n=================================================================================================================\n");

        System.out.println("Tournament System exits.");
    }
}
