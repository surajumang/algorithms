package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class CoinChangeNumberOfWays {
    static int ways = 0;
    static Map<Integer, Long> change = new HashMap<>();

    public static void main(String[] args){
        // N m follwed by m integers representing the coins.
        int N = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] coins = new int[m];
        System.out.println(N + " " + m);

        for (int i = 2; i < m+2; i++) {
            coins[i-2] = Integer.parseInt(args[i]);
        }
        System.out.print(coins[0] + " " + coins[1]);
        countWays(N, coins);
        System.out.println(change);

    }

    static void countWays(int N, int[] coins){
        //printing every invokation
        System.out.println(N);
        long sum = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == N){
                System.out.println(coins[i] + "Exact match found");
                change.put(coins[i], (long) 1);
                return;
            }
            if (coins[i] < N){
                if (change.get(N - coins[i]) != null){
                    System.out.println((N - coins[i]) + "Found in Cache");
                    sum += change.get(N - coins[i]);
                }else {
                    countWays(N-coins[i], Arrays.copyOfRange(coins, i, coins.length));
                }
            }
        }

        if (sum != 0) change.put(N, sum);
    }
}
