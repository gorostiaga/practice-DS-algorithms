package com.maps;

import java.util.HashMap;
import java.util.Map;

public class Tester {

    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<>();
        maps.put("Pepe", "Cirilo");
        maps.put("Pepe", "Tibucrio");

        System.out.println(maps.get("Pepe"));
    }
}
