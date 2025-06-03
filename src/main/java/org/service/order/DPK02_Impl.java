package org.service.order;

import java.util.HashMap;
import java.util.Map;

public class DPK02_Impl {

    public static String lookup(Map<Integer, String> peopleMap, int id) {
        System.out.println(" (ID to Name): Looking up ID " + id);
        return peopleMap.get(id);
    }

    public static void main(String[] args) {

        System.out.println("\n--- Initial Lookup (ID to Name) ---");
        Map<Integer, String> initialPeopleMap = new HashMap<>();
        initialPeopleMap.put(1, "Pedro");
        initialPeopleMap.put(2, "Maria");
        initialPeopleMap.put(3, "Alice");

        System.out.println("Result: " + lookup(initialPeopleMap, 1));
        System.out.println("Result: " + lookup(initialPeopleMap, 4));

    }

}
