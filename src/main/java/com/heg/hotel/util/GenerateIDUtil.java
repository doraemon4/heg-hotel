package com.heg.hotel.util;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @ClassName GenerateIDUtil
 * @Description 生成唯一的序号
 * @Author jack
 * @Date 2024/8/14 17:05
 */
public class GenerateIDUtil {
    public static String[] chars = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 36]);
        }
        return shortBuffer.toString();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 1000000; i++) {
            set.add(generateShortUuid());
        }
        System.out.println(set.size());
    }
}
