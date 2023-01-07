package com.comp6481;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Qadian Marathon
 * You are given the list of prizes and initial money. You have an initial score of 0. There are 2
 * actions that you could perform.
 * 1. Boost up : you can boost up if your money>= prize. If you boost up, you gain 1
 * score but you lose money by prize value.
 * 2. Boost down : you can boost down if your score>0. If you boost down, you lose
 * score by 1 but you gain money by prize value.
 * Your goal is to find the maximum score you could achieve by running through all the
 * prizes. You can pick prizes in any order. Each prize can be picked only once.
 * The first line contains 2 integers separated by space . First Integer is N which is the total
 * number of prizes. Second integer is the initial money. Second line, list of prizes with
 * space-separated.
 * Initial money >0
 * Prizes values >0
 * Output: Maximum score
 *
 * Examples:
 *
 * Input:
 * 1 50
 * [100]
 * Output:
 * 0
 * Explanation: You cannot boost up or boost down.
 *
 * Input:
 * 4 200
 * [100,200,300,400]
 * Output:
 * 2
 * Explanation: Play the prizes in this order
 * to get a score of 2:
 * 1. Play the 0th prize (100)
 * boost up, your money
 * becomes 100 and score
 * becomes 1.
 * 2. Play the 3rd prize (400)
 * boost down, your money
 * becomes 500 and score
 * becomes 0.
 * 3. Play the 1st prize (200)
 * face up, your money
 * becomes 300 and score
 * becomes 1.
 * 4. Play the 2nd prize(300)
 * boost up, your money
 * becomes 0 and score
 * becomes 2.
 */

public class Pod0102F22 {

    private static int getResult(Integer[] prizes, int currentMoney) {
        int score = 0;
        int totalMoney = Arrays.stream(prizes).reduce((x, y) -> x + y).get();
        Arrays.sort(prizes);
        if (prizes == null || prizes.length == 0 || prizes[0] > currentMoney) {
            return score;
        } else if (currentMoney >= totalMoney) {
            return prizes.length;
        }

        int i = -1, j = prizes.length;
        int lastDifference = Math.abs(totalMoney - currentMoney), currentDifference;
        do {
            i++;
            j--;
            currentMoney = currentMoney - prizes[i] + prizes[j];
            totalMoney = totalMoney - prizes[i] - prizes[j];
            currentDifference = Math.abs(totalMoney - currentMoney);
            if (currentDifference >= lastDifference) {
                currentMoney = currentMoney + prizes[i] - prizes[j];
                break;
            }
            lastDifference = currentDifference;
        } while (i <= j);
        for (int k = i; k <= j; k++) {
            if (currentMoney >= prizes[k]) {
                score++;
                currentMoney -= prizes[k];
            }
        }
        return score;
    }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String firstDataStr = scanner.nextLine();
        Integer[] firstData = Arrays.stream(firstDataStr.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int currentMoney = firstData[1];
        String secondDataStr = scanner.nextLine();
        Integer[] prizes = Arrays.stream(secondDataStr.split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(getResult(prizes, currentMoney));*/

//        System.out.println(getResult(new Integer[]{100}, 50)); // 0
//        System.out.println(getResult(new Integer[]{100, 200, 300, 400}, 200)); // 2
//        System.out.println(getResult(new Integer[]{100, 100, 100, 200, 300, 300}, 300)); // 3
//        System.out.println(getResult(new Integer[]{100, 100, 100, 200, 300, 300}, 600)); // 4
//        System.out.println(getResult(new Integer[]{300, 400, 600, 600, 800, 800}, 1200)); // 3
//        System.out.println(getResult(new Integer[]{100, 200, 200, 300, 300, 300, 800}, 1200)); // 5
        System.out.println(getResult(new Integer[]{100, 200, 300}, 200)); // 5
    }
}
