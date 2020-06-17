package com.sunil.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * For a given number find factors and from those factors form a combination such a way that sum of digits of the
 * combination is equal to it's number and output is max value of those multiplications
 * among all possible combinations.
 * <p>
 * Example:
 * Given number --> 8 --> Factors are : 1, 2, 4 --> combinations are (a) 1 + 1 + 2 + 4 = 8 (b) 2 + 2 + 2 + 2 = 8
 * and multiplications of those combinations are (a) --> 8 and (b) --> 16. So final answer is 16.
 *
 * Given number --> 18 --> Factors are : 1, 2, 3, 6, 9 --> combinations are (a) 9 + 1 + 6 + 2 = 18 (b) 3 + 3 + 6 + 6 = 18
 * and multiplications of those combinations are (a) --> 108 and (b) --> 324. So answer is 324.
 */
public class MaxProductFromFactorsCombination {
    public static void main(String[] args) {
        int number = 18;

        List<Integer> candidates = getCandidates(number);

        List<List<Integer>> combinationsList = getCombinations(candidates, number);

        int maxProduct = Integer.MIN_VALUE;
        for (List<Integer> combination : combinationsList) {
            int mul = 1;
            for (Integer integer : combination) {
                mul = mul * integer;
            }

            if (mul > maxProduct) {
                maxProduct = mul;
            }
        }
        System.out.println("Max product is " + maxProduct);
    }

    private static List<Integer> getCandidates(int number) {
        List<Integer> candidates = new ArrayList<>();
        IntStream.range(1, number + 1).forEach(i -> {
            if (number % i == 0) {
                candidates.add(i);
            }
        });
        return candidates;
    }

    private static List<List<Integer>> getCombinations(List<Integer> candidates, int number) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Collections.sort(candidates);
        getResults(results, combination, candidates, number, 0);
        return results;
    }

    private static void getResults(List<List<Integer>> results, List<Integer> combination, List<Integer> candidates, int target, int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < candidates.size(); i++) {
            if (candidates.get(i) > target) {
                break;
            }
            combination.add(candidates.get(i));
            getResults(results, combination, candidates, target - candidates.get(i), i);
            combination.remove(combination.size() - 1);
        }
    }
}
