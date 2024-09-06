package com.heg.hotel.util;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description Jaccard 相似度匹配
 * @Author jack
 * @Date 2024/8/20 23:29
 */
public class JaccardUtil {
    public static double computeJaccardSimilarity(String text1, String text2) {

        Set<String> set1 = Sets.newHashSet(text1.split("\\s+"));
        Set<String> set2 = Sets.newHashSet(text2.split("\\s+"));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static void main(String[] args) {
        String text1 = "I love programming in Java";
        String text2 = "I love Java programming";

        double similarity = computeJaccardSimilarity(text1, text2);
        System.out.println("Jaccard Similarity: " + similarity);
    }
}
