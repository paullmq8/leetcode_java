package com.comp6481.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

// Assignment 2
// Question: Part II, Question III
// Written by: Mengqi Liu - 40221432
// -----------------------------------------------------

/**
 * Assignment 2<br/>
 * Due Date: 2022.11.27<br/>
 * Mengqi LIU - 40221432<br/>
 */
public class TeamList {

    /**
     * inner class to wrap node object in a team list
     * the value of the node is a team object.
     * there's another reference next pointing to the next node following the current one.
     */
    public static class TeamNode implements Cloneable {

        private Team team;
        private TeamNode next;

        public TeamNode() {}

        /**
         * constructor of class TeamNode
         * @param t the team as the value
         * @param next the next TeamNode following the current one
         */
        public TeamNode(Team t, TeamNode next) {
            this.team = t;
            this.next = next;
        }

        /**
         * copy constructor of class TeamNode. clone() method will be called to do deep clone object.
         * @param tn the TeamNode object to be copied.
         */
        public TeamNode(TeamNode tn) {
            TeamNode node = tn.clone();
            this.team = node.team;
            this.next = node.next;
        }

        /**
         * method of clone() overriding method Object.clone() to implement deep clone.
         * @return deep cloned TeamNode object
         */
        @Override
        public TeamNode clone() {
            TeamNode clonedNode = new TeamNode();
            clonedNode.team = new Team(this.team, this.team.getTeamID());
            if (this.next == null) {
                clonedNode.next = null;
            } else {
                clonedNode.next = this.next.clone();
            }
            return clonedNode;
        }

        /**
         * method of getting Team object
         * @return the Team object
         */
        public Team getTeam() {
            return team;
        }

        /**
         * method of setting Team object
         * @param team team object to be set
         */
        public void setTeam(Team team) {
            this.team = team;
        }

        /**
         * method of getting next TeamNode object
         * @return the next TeamNode object
         */
        public TeamNode getNext() {
            return next;
        }

        /**
         * method of setting next TeamNode object
         * @param next the next TeamNode object to be set
         */
        public void setNext(TeamNode next) {
            this.next = next;
        }
    }

    private TeamNode head; // head points to the first node in this TeamList

    private int size; // size indicates how many nodes are currently in the list

    private List<Integer> highestTwoPoints = new ArrayList<>();
    private List<Double> highestTwoNetRunRates = new ArrayList<>();

    /**
     * default constructor of class TeamList
     */
    public TeamList() {}

    /**
     * constructor of class TeamList constructing the head node and list size
     * @param head the TeamNode object to be set as head of the list
     * @param size the list size
     */
    public TeamList(TeamNode head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
     * copy constructor of class TeamList.
     * will do deep clone for each node in the list.
     * @param list the deep cloned new team list
     */
    public TeamList(TeamList list) {
        this.size = list.size;
        this.head = list.head.clone();
    }

    /**
     * method of getting head
     * @return head TeamNode object
     */
    public TeamNode getHead() {
        return head;
    }

    /**
     * method of getting size
     * @return the size value in integer
     */
    public int getSize() {
        return size;
    }

    /**
     * method of getting highestTwoPoints
     * @return the highest two point values in the team list after comparing all the nodes in the team list
     */
    public List<Integer> getHighestTwoPoints() {
        return highestTwoPoints;
    }

    /**
     * method of getting highestTwoNetRunRates
     * @return the highest two net run rate values in the team list after comparing all the nodes in the team list
     */
    public List<Double> getHighestTwoNetRunRates() {
        return highestTwoNetRunRates;
    }

    /**
     * wrap a Team object as a TeamNode object and add it to the start of the team list.
     * if the Team object already exists in the team list, it won't be added into the team list.
     * @param t the Team object to be added
     */
    public void addToStart(Team t) {
        if (t != null && findNodeByTeam(t) == null) {
            TeamNode teamNode = new TeamNode(t, head);
            head = teamNode;
            size++;
        }
    }

    /**
     * remove the head node from the team list
     */
    public void deleteFromStart() {
        if (head != null) head = head.next;
        size--;
    }

    /**
     * wrap a Team object as a TeamNode object and insert it at the specified index in the team list.
     * @param t the Team object to be inserted into the team list.
     * @param idx the index where the data will be inserted.
     */
    public void insertAtIndex(Team t, int idx) {
        if (idx < 0 || idx > size) throw new NoSuchElementException();
        if (t != null && findNodeByTeam(t) == null) {
            if (idx == 0) {
                addToStart(t);
            } else {
                TeamNode tempNode = getTeamNodeAtIndex(idx - 1);
                TeamNode newNode = new TeamNode(t, tempNode.next);
                tempNode.next = newNode;
                size++;
            }
        }
    }

    /**
     * find a TeamNode with the specified teamID
     * @param teamID the teamID to be found
     * @return the TeamNode found in the team list. Null if not found.
     */
    public TeamNode find(String teamID) {
        return traverseAndFind(t -> t.getTeamID().equalsIgnoreCase(teamID));
    }

    /**
     * find a TeamNode with the specified teamID and print the needed number of iterations
     * @param teamID the teamID to be found
     * @return the TeamNode found in the team list. Null if not found.
     */
    public TeamNode findAndPrintIteration(String teamID) {
        TeamNode node = head;
        Function<Team, Boolean> function = t -> t.getTeamID().equalsIgnoreCase(teamID);
        int numberOfIteration = 1;
        while (node != null && !function.apply(node.getTeam())) {
            node = node.next;
            numberOfIteration++;
        }
        if (node != null) {
            System.out.println("numberOfIteration= " + numberOfIteration);
        }
        return node;
    }

    /**
     * find TeamNode by teamName. Null if not found.
     * @param teamName the teamName value to find with
     * @return the TeamNode object found in the list. Returns null if not found.
     */
    public TeamNode findByTeamName(String teamName) {
        return traverseAndFind(t -> t.getTeamName().equalsIgnoreCase(teamName));
    }

    /**
     * check if the team list contains a node with the teamID
     * @param teamID the teamID to be found
     * @return true if found a node with the teamID. Otherwise, false.
     */
    public boolean contains(String teamID) {
        return find(teamID) == null ? false : true;
    }

    /**
     * check if two team lists are the same.
     * @param list the team list to be compared with.
     * @return true if two team lists are the same. Otherwise, false.
     */
    public boolean equals(TeamList list) {
        if (this.size != list.size) return false;
        List<Team> thisTeams = this.traverseAndGatherAllTeams();
        List<Team> listTeams = list.traverseAndGatherAllTeams();
        if (!thisTeams.containsAll(listTeams) || !listTeams.containsAll(thisTeams)) return false;
        return true;
    }

    /**
     * delete the node in the team list at the specified index.
     * @param idx the index of the node to be deleted.
     */
    public void deleteFromIndex(int idx) {
        if (invalidIndex(idx)) throw new NoSuchElementException();
        if (idx == 0) {
            deleteFromStart();
        } else {
            TeamNode preNode = getTeamNodeAtIndex(idx - 1);
            if (preNode.next.next == null) {
                preNode.next = null;
            } else {
                preNode.next = preNode.next.next;
            }
            size--;
        }
    }

    /**
     * replace a node with the Team object at a specified index in the team list.
     * @param t the Team object to be replaced with.
     * @param idx the target index in the team list.
     */
    public void replaceAtIndex(Team t, int idx) {
        if (invalidIndex(idx)) return;
        if (t != null && findNodeByTeam(t) == null) {
            TeamNode teamNode = getTeamNodeAtIndex(idx);
            teamNode.setTeam(t);
        }
    }

    /**
     * traverse the team list and find a node with the specified condition
     * @param function the condition to find the node
     * @return the found TeamNode. Null if not found.
     */
    private TeamNode traverseAndFind(Function<Team, Boolean> function) {
        TeamNode node = head;
        while (node != null && !function.apply(node.getTeam())) {
            node = node.next;
        }
        return node;
    }

    /**
     * check if an index is valid or not.
     * @param idx the index to be checked.
     * @return true if the index is not valid. Otherwise, false.
     */
    private boolean invalidIndex(int idx) {
        return idx < 0 || idx > size - 1 ? true : false;
    }

    /**
     * traverse and gather all team objects in each node of the list.
     * @return all gathered team objects in the list.
     */
    private List<Team> traverseAndGatherAllTeams() {
        List<Team> list = new ArrayList<>(size);
        TeamNode node = head;
        while (node != null) {
            list.add(node.getTeam());
            node = node.next;
        }
        return list;
    }

    /**
     * find the TeamNode object at the specified index.
     * @param idx the target index
     * @return the TeamNode at idx position in the team list.
     */
    private TeamNode getTeamNodeAtIndex(int idx) {
        TeamNode tempNode = head;
        if (idx == 0) {
            return tempNode;
        }
        for (int i = 1; i < idx; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /**
     * find the TeamNode in the list with the specified Team object.
     * @param team the searched Team object
     * @return the found TeamNode. Null if not found.
     */
    private TeamNode findNodeByTeam(Team team) {
        return traverseAndFind(t -> t.getTeamID().equals(team.getTeamID()) && t.equals(team));
    }
}
