package com.heg.hotel.util;

/**
 * @Description Levenshtein距离相似度算法，用于名称相似度计算
 * @Author jack
 * @Date 2024/8/20 12:03
 */
public class LevenshteinUtil {
    public static double getLevenshteinSimilarity(String str1, String str2) {
        int distance = getLevenshteinDistance(str1, str2);
        return 1.0 - (double) distance / Math.max(str1.length(), str2.length());
    }

    private static int getLevenshteinDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                    );
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String text1 = "138 Pittsburgh Rd, 16001";
        String text2 = "138 Pittsburgh Rd";

        double similarity = getLevenshteinSimilarity(text1, text2);
        System.out.println("Levenshtein Similarity: " + similarity);
    }
}
