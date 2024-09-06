package com.heg.hotel.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 相似度匹配
 * @Author jack
 * @Date 2024/8/20 23:24
 */
public class CosineSimilarityUtil {
    public static double computeCosineSimilarity(String text1, String text2) {
        Map<String, Integer> vector1 = getTermFrequency(text1);
        Map<String, Integer> vector2 = getTermFrequency(text2);

        double dotProduct = 0.0;
        for (String key : vector1.keySet()) {
            if (vector2.containsKey(key)) {
                dotProduct += vector1.get(key) * vector2.get(key);
            }
        }

        double magnitude1 = 0.0;
        for (int value : vector1.values()) {
            magnitude1 += Math.pow(value, 2);
        }

        double magnitude2 = 0.0;
        for (int value : vector2.values()) {
            magnitude2 += Math.pow(value, 2);
        }

        return dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
    }

    private static Map<String, Integer> getTermFrequency(String text) {
        Map<String, Integer> termFrequency = new HashMap<>();
        for (String term : text.split("\\s+")) {
            termFrequency.put(term, termFrequency.getOrDefault(term, 0) + 1);
        }
        return termFrequency;
    }

    public static void main(String[] args) {
        String text1 = "138 Pittsburgh Rd 16001";
        String text2 = "138 Pittsburgh Rd";

        double similarity = computeCosineSimilarity(text1, text2);
        System.out.println("cosine Similarity: " + similarity);
    }
}
