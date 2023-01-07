package com.comp6481;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Hotel Room
 * The hotel manager wants to assign the room to the customer. The hotel has N rooms, and each room numbered
 * with 1 to N. Now all rooms are available. The manager wants assign the room according to the following rules.
 * 1. Each customer gives the room number they wish to stay in
 * 2. If the room is available, manager can assign the room
 * 3. If the room is already assigned, the manager can assign the room with the lowest number among the
 * available rooms and also with a larger number than the desired room
 *
 * Input:
 * The first line contains one positive integer N which is total number of rooms
 * The second line, list of customers’ desired room numbers with space-separated
 *
 * Output:
 * Print, list of room numbers that assigned to customer with space-separated
 *
 * Examples:
 * Input:
 * 10
 * 1 3 4 1 3 1
 * Output:
 * 1 3 4 2 5 6
 *
 * Input:
 * 20
 * 3 5 2 1 7 19 2 6 7 8 15 16 19 14
 * Output:
 * 3 5 2 1 7 19 4 6 8 9 15 16 20 14
 */

public class Pod0101F22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRooms = Integer.parseInt(scanner.nextLine());
        String data = scanner.nextLine();
        String[] wishedRoomNumbersInStr = data.split(" ");
        Integer[] wishedRoomNumbers = Arrays.stream(wishedRoomNumbersInStr).map(Integer::parseInt).toArray(Integer[]::new);
        Set<Integer> assignedRoomNumbers = new HashSet<>(numberOfRooms);
        for (int wishedRoomNumber : wishedRoomNumbers) {
            if (!assignedRoomNumbers.contains(wishedRoomNumber)) {
                System.out.print(wishedRoomNumber + " ");
                assignedRoomNumbers.add(wishedRoomNumber);
                continue;
            }
            do {
                wishedRoomNumber++;
            } while(assignedRoomNumbers.contains(wishedRoomNumber));
            System.out.print(wishedRoomNumber + " ");
            assignedRoomNumbers.add(wishedRoomNumber);
        }
    }
}
