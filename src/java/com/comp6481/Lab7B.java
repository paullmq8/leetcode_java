package com.comp6481;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab7B {
    /*
    10
    11
    8 8 7 6 5 4 3 2 2 1 1
    [322111, 541, 631, 721, 4321, 811, 82, 73, 64]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] nums = Arrays.stream(scanner.nextLine().split(" ")).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);

        int l, h, sum;
        StringBuffer sb;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > t) continue;
            if (nums[i] == t) {
                set.add("" + nums[i]);
                continue;
            }
            sb = new StringBuffer();
            sum = nums[i];
            sb.append(nums[i]);
            for (l = i + 1; l < nums.length; l++) {
                sum += nums[l];
                if (sum > t) {
                    sum -= nums[l];
                } else if (sum == t) {
                    set.add(sb.toString() + nums[l]);
                    sum -= nums[l];
                } else {
                    sb.append(nums[l]);
                    h = l + 1;
                    while (h < nums.length && sum <= t) {
                        sum += nums[h];
                        if (sum > t) {
                            sum -= nums[h];
                            h++;
                        } else if (sum == t) {
                            set.add(sb.toString() + nums[h]);
                            sum -= (nums[l] + nums[h]);
                            break;
                        } else {
                            sb.append("" + nums[h]);
                            h++;
                        }
                    }
                }
            }
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
