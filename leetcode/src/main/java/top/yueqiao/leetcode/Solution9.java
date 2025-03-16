package top.yueqiao.leetcode;

/**
 * @author : yueqiao
 * @date : 2025/3/16 23:22
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int temp = x;
        int result = 0;
        while (temp != 0) {
            int mod = temp % 10;
            result = result * 10 + mod;
            temp = temp / 10;
        }
        return x == result;
    }

}
