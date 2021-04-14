package com.sunil.leetcode.dd;

/**
 * Given n orders, each order consist in pickup and delivery services.
 * <p>
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: 1
 * Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
 *
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 6
 * Explanation: All possible orders:
 * (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
 * This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
 *
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: 90
 */
public class CountValidPickupDeliveryOptions {
    public static void main(String[] args) {
        int n = 3;

        System.out.println("Number of valid pickup and delivery options : " + countOrders(n));
    }

    private static int countOrders(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i * (2 * i - 1);
            result = result % ((long) (1e9 + 7));
        }
        return (int) result;
    }
}
