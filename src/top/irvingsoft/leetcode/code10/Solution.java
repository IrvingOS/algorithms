package top.irvingsoft.leetcode.code10;

/**
 * 正则表达式匹配
 *
 * @author TimeChaser
 * @since 2021/11/1 13:41
 */
public class Solution {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 多留出一行和一列指示初始状态
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 如果 * 修饰的模式字符个数为 0 的情况下，此时的状态与 * 修饰的模式字符之前的状态一致
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        // 此时 * 修饰的模式字符与被匹配的字符相同，此时的状态与被匹配的字符之前的字符状态一致
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        // 此时的状态与各自之前的字符状态一致
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        System.out.println("aaa");
        System.out.println("ab*a*c*a");
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("aaa", "a*."));
    }
}