package com.mrl.emulate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuchun
 * @date 2020/02/29  10:00
 */
public class Test {
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
//        Integer integer = integers.stream().sorted().min((o1, o2) -> o2 - o1).get();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("way_1", 1);
        map.put("way_2", 2);
        map.put("way_3", 3);
        map.put("way_4", 4);
        Map.Entry<String, Integer> integerEntry = map.entrySet().stream().min((o1, o2) -> o1.getValue() - o2.getValue()).get();

        System.out.println(integerEntry.getKey());


//        System.out.println(stringIntegerEntry);
    }
}
