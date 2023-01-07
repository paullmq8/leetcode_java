package com.comp6481;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam3B {
    /*
    0
    1

    00
    01
    11
    10

    000
    001
    011
    010
    110
    111
    101
    100
     */

    private static List<String> getList(int n) {
        List<String> result = new ArrayList<>();
        result.add("0");
        result.add("1");
        if (n == 1) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add("1" + result.get(j));
                result.set(j, "0" + result.get(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        List<String> strList = getList(Integer.parseInt(data[0]));
        System.out.println(strList);
        String resultStr = strList.get(Integer.parseInt(data[1]));
        int result = Integer.parseUnsignedInt(resultStr, 2);
        System.out.printf("%d %s\n", result, resultStr);
        String resultStrAnother = Integer.toBinaryString(result);
        System.out.println(resultStrAnother);
    }
}
