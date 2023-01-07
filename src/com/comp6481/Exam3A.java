package com.comp6481;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

//all permutation
public class Exam3A {

    private static int nFactorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * nFactorial(n - 1);
        }
    }

    private static int[][] getAllComposition(int n) {
        int nFactorial = nFactorial(n);
        int[][] allComposition = new int[nFactorial][n];

        return allComposition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[][] allCompositions = getAllComposition(input.length());
        Set<String> set = new HashSet<>();
        StringBuffer sb;
        for (int i = 0; i < allCompositions.length; i++) {
            sb = new StringBuffer();
            for (int j = 0; j < allCompositions[i].length; j++) {
                sb.append(input.charAt(allCompositions[i][j]));
            }
            set.add(sb.toString());
        }
        List<String> result = set.stream().collect(Collectors.toList());
        result.sort(Comparator.naturalOrder());
        result.forEach(s -> System.out.printf(s + " "));
    }
}
