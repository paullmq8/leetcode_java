package com.comp6481.assignment1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//________________________________
// Assignment 1
// Mengqi Liu
// Written by: Mengqi Liu 40221432
//________________________________
public class Driver {

    /**
     * the array storing all Voters under track
     */
    private static Voter[] voterBase;

    /**
     * constant password for the system
     */
    private static final String PASSWORD = "password";

    /**
     * main function for Driver class
     * @param args
     */
    public static void main(String[] args) {

        //system input scanner for the whole program
        Scanner scanner = new Scanner(System.in);

        //print welcome information
        System.out.println("Welcome to the System of Parti Québécois\n");

        //prompting for the maximum number of voters
        System.out.print("Please enter the maximum number of voters > ");
        int maxVoters = Integer.parseInt(scanner.nextLine());

        //after receiving the maximum number of voters, initialize the Voter array
        voterBase = new Voter[maxVoters];

        //option is defined for the main menu chosen by the user
        int option = -1;

        // passwordAttemptCountInOption1 records the total count of password attempt failure for option 1
        int passwordAttemptCountInOption1 = 0;
        // passwordAttemptCountInOption2 records the total count of password attempt failure for option 2
        int passwordAttemptCountInOption2 = 0;
        char choice;

        //main menu loop until user enters 5
        OUTER:
        do {
            //prompting the main menu
            System.out.printf("What do you want to do?\n" +
                    "\t1. Enter new voters (password required)\n" +
                    "\t2. Change information of a voter (password required)\n" +
                    "\t3. Display all voters by a specific voterPcode\n" +
                    "\t4. Display all voters under a certain age.\n" +
                    "\t5. Quit\n" +
                    "Please enter your choice > ");

            //user has to enter valid menu option, otherwise the main menu will keeping prompting
            try {
                String optionStr = scanner.nextLine();
                option = Integer.parseInt(optionStr);
            } catch (Exception e) {
                continue;
            }

            //passwordAttempt temporarily records the password user tries every time.
            String passwordAttempt;

            //check the option user chooses and go to different workflow
            switch (option) {
                case 1://insert or update voter data
                    do {
                        System.out.print("Please enter your password: ");
                        passwordAttempt = scanner.nextLine();
                        if (!PASSWORD.equals(passwordAttempt)) {
                            System.out.println("Password is incorrect.");
                            //every time the password attempt fails, the passwordAttemptCountInOption1 increases by 1 to record the count.
                            ++passwordAttemptCountInOption1;

                            //if 12 consecutive times of password attempt failures happen, exit the system directly.
                            if (passwordAttemptCountInOption1 == 12) {
                                System.out.println("Program detected suspicious activities and will terminate immediately!");
                                break OUTER;
                            }

                            //if tried another 3 times, redirect to the main menu
                            if (passwordAttemptCountInOption1 % 3 == 0) continue OUTER;
                        } else {
                            //if the tried password is correct, exit the current infinite do while loop.
                            break;
                        }
                    } while(true);

                    System.out.println("Password is correct.");
                    passwordAttemptCountInOption1 = 0;
                    System.out.print("How many voters do you want to enter? > ");
                    int moreVoters = Integer.parseInt(scanner.nextLine());
                    int remainingVoters = maxVoters - Voter.findNumberOfCreatedVoters();
                    //check if there's still enough vacancy in the Voter array
                    if (remainingVoters < moreVoters) {
                        System.out.println("Sorry, you can only add " + remainingVoters + " voters now.");
                        moreVoters = remainingVoters;
                    } else {
                        System.out.println("Yes, you can continue to add " + moreVoters + " voters.");
                    }
                    System.out.println("The voters information should be entered in the format: voterID|voterName|voterAge|voterEmail|voterPcode");
                    //now the moreVoters records the total count the user could continue entering info in the array and keep looping until the total count is reached.
                    for (int i = 0; i < moreVoters; i++) {
                        String voterData = scanner.nextLine();
                        //since each data is separated by char |, the split function could get an array for respective fields of Voter object
                        //be careful of the order of data
                        String[] data = voterData.split("\\|");
                        long voterID = Long.parseLong(data[0]);
                        //check if the voterID already exists. If yes, the user could choose to update corresponding data or just skip the record he just entered.
                        Optional<Voter> possibleVoter = findVoterByID(voterID, voterBase);
                        if (possibleVoter.isPresent()) {
                            System.out.print("The voter with ID " + voterID + " already exists! Do you want to skip or update? range: (s/u) > ");
                            String choiceStr = scanner.nextLine();
                            choice = choiceStr.charAt(0);
                            switch (choice) {
                                case 'u': //update the corresponding data he just entered for the existing voterID.
                                    Voter existingVoter = possibleVoter.get();
                                    existingVoter.setVoterName(data[1]);
                                    existingVoter.setVoterAge(Byte.parseByte(data[2]));
                                    existingVoter.setVoterEmail(data[3]);
                                    existingVoter.setVoterPcode(data[4].toCharArray());
                                    System.out.println("Voter is updated!");
                                    break;
                                case 's': //just skip the same record
                                default:
                                    System.out.println("Voter is skipped!");
                            }
                        } else {
                            //if the voterID doesn't exist, create a new Voter object and add it into the array
                            Voter newVoter = new Voter(voterID, data[1], Byte.parseByte(data[2]), data[3], data[4].toCharArray());
                            //Voter.findNumberOfCreatedVoters() records the total initialized Voter objects count, minus 1 is the index for the new object in the array
                            voterBase[Voter.findNumberOfCreatedVoters() - 1] = newVoter;
                            System.out.println("Voter is added!");
                        }
                    }
                    break;
                case 2://update voter data by their voterID
                    //keep looping until password is correct or 3 times failures happen and show the main menu
                    do {
                        System.out.print("Please enter your password: ");
                        passwordAttempt = scanner.nextLine();
                        if (!PASSWORD.equals(passwordAttempt)) {
                            System.out.println("Password is incorrect.");
                            ++passwordAttemptCountInOption2;
                            if (passwordAttemptCountInOption2 == 3) {
                                passwordAttemptCountInOption2 = 0;
                                continue OUTER;
                            }
                        } else {
                            break;
                        }
                    } while(true);

                    System.out.println("Password is correct.");

                    //keep looping until user chooses 5 to exit the option 2.
                    OUTER_INFINIT:
                    for (;;) {
                        System.out.print("Which voter do you want to update? The voterID > ");
                        String updateVoterIDStr = scanner.nextLine();
                        long updateVoterID = Long.parseLong(updateVoterIDStr);
                        //loop to find the Voter object and its index in the array by the chosen voterID
                        int index = IntStream.range(0, voterBase.length).filter(i ->
                                Objects.nonNull(voterBase[i]) && updateVoterID == voterBase[i].getVoterID()).findFirst().orElse(-1);
                        if (index >= 0) {// the voterID exists in the array
                            Voter updateVoter = voterBase[index];//get the Voter object by the index
                            //update each field of Voter object except voterID and print the data after updating
                            //since the array stores all Voter object references, when the object is updated, the objects stored in the array are also updated.
                            INNER_INFINIT:
                            for (;;) {
                                System.out.println("Current information of that voter: \n" + "Voter: # " + index
                                        + "\n" + updateVoter);
                                System.out.printf("What information would you like to change now?" +
                                        "\n\t1. Name\n\t2. Age\n\t3. Email\n\t4. PCode\n\t5. Quit\n" +
                                        "Enter your choice > ");
                                String choiceStr = scanner.nextLine();
                                switch (choiceStr) {
                                    case "1":
                                        System.out.printf("Please enter new name > ");
                                        String newName = scanner.nextLine();
                                        updateVoter.setVoterName(newName);
                                        break;
                                    case "2":
                                        System.out.printf("Please enter new age > ");
                                        String newAge = scanner.nextLine();
                                        updateVoter.setVoterAge(Byte.parseByte(newAge));
                                        break;
                                    case "3":
                                        System.out.printf("Please enter new email > ");
                                        String newEmail = scanner.nextLine();
                                        updateVoter.setVoterEmail(newEmail);
                                        break;
                                    case "4":
                                        System.out.printf("Please enter new pcode > ");
                                        String newPcode = scanner.nextLine();
                                        updateVoter.setVoterPcode(newPcode.toCharArray());
                                        break;
                                    case "5":
                                        break INNER_INFINIT;
                                }
                            }
                            break;
                        } else {// the voterID doesn't exist in the array
                            for (;;) {
                                System.out.println("The voterID " + updateVoterID + " doesn't exist.");
                                System.out.print("Do you want to re-enter another voterID ? range: (y/n) > ");
                                String yesOrNoStr = scanner.nextLine();
                                char yesOrNo = yesOrNoStr.charAt(0);
                                switch (yesOrNo) {//user could re-enter another voterID by entering y or leave the option 2 by entering n
                                    case 'y':
                                        continue OUTER_INFINIT;
                                    case 'n':
                                        break OUTER_INFINIT;
                                }
                            }
                        }
                    }
                    break;
                case 3://search all voters by the pcode
                    System.out.print("Please enter a voterPcode > ");
                    String searchVoterPcode = scanner.nextLine();
                    //find all the voters by the pcode
                    List<Voter> votersInTheSamePcode = findVotersByPcode(searchVoterPcode, voterBase);
                    if (votersInTheSamePcode.isEmpty()) {
                        System.out.println("There's no voter residing in the pcode " + searchVoterPcode);
                    } else {
                        printVoters(votersInTheSamePcode);
                    }
                    break;
                case 4://search all voters under some given age
                    byte searchAge;
                    //keep looping until user enters a valid age
                    do {
                        try {
                            //since age is stored in byte type, there's a range for the input.
                            System.out.print("Please enter an age, range: (1 - " + Byte.MAX_VALUE + ") > ");
                            String searchAgeStr = scanner.nextLine();
                            searchAge = Byte.parseByte(searchAgeStr);
                            if (searchAge < 1 || searchAge > Byte.MAX_VALUE) continue;
                            break;
                        } catch (Exception e) {
                        }
                    } while (true);
                    //find all the voter objects whose age is less than searchAge
                    List<Voter> votersYoungerThanAge = findYoungerThan(searchAge, voterBase);
                    if (votersYoungerThanAge.isEmpty()) {
                        System.out.println("There's no voter who is younger than " + searchAge);
                    } else {
                        printVoters(votersYoungerThanAge);
                    }
                    break;
                case 5://exit the whole program
                    break;
            }
        } while(option != 5);
        System.out.println("System exits.");
    }

    //search voter objects by case-insensitive pcode
    private static List<Voter> findVotersByPcode(String searchPcode, Voter[] voterBase) {
        return Arrays.stream(voterBase).filter(v
                -> Objects.nonNull(v) && String.valueOf(v.getVoterPcode()).equalsIgnoreCase(searchPcode)).collect(Collectors.toList());
    }

    //search the voter object by comparing the voterID
    private static Optional<Voter> findVoterByID(long voterID, Voter[] voterBase) {
        return Arrays.stream(voterBase).filter(v -> Objects.nonNull(v) && v.getVoterID() == voterID).findAny();
    }

    //find all voter objects whose age is less than searchAge
    private static List<Voter> findYoungerThan(byte searchAge, Voter[] voterBase) {
        return Arrays.stream(voterBase).filter(v
                -> Objects.nonNull(v) && v.getVoterAge() < searchAge).collect(Collectors.toList());
    }

    //print all voters in the list. will call toString() method of Voter object.
    private static void printVoters(List<Voter> voters) {
        voters.forEach(v -> System.out.println(v + "\n===================="));
    }
}
