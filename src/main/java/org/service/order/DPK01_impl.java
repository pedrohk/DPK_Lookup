package org.service.order;

import java.util.HashMap;
import java.util.Map;

public class DPK01_impl {

    private Map<Integer, String> idToName = new HashMap<>();
    private Map<String, String> nameToEmail = new HashMap<>();
    private Map<String, String> emailToName = new HashMap<>();

    public DPK01_impl() {

        idToName.put(1, "John");
        nameToEmail.put("John", "john@john.com");
        emailToName.put("john@john.com", "John");

        idToName.put(2, "Alice");
        nameToEmail.put("Alice", "alice@gmail.org");
        emailToName.put("alice@gmail.org", "Alice");

        idToName.put(3, "Bob");
        nameToEmail.put("Bob", "bob.thebuilder@gmail.net");
        emailToName.put("bob.thebuilder@gmail.net", "Bob");
    }

    // Initial lookup by ID
    public String lookup(int id) {
        return idToName.get(id);
    }

    // Refactored lookup handling ID, name, and email (both directions)
    public String lookup(Object key) {
        if (key instanceof Integer) {
            return idToName.get(key);
        } else if (key instanceof String) {
            String strKey = (String) key;
            if (nameToEmail.containsKey(strKey)) {
                return nameToEmail.get(strKey);
            } else if (emailToName.containsKey(strKey)) {
                return emailToName.get(strKey);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        DPK01_impl userLookup = new DPK01_impl();

        System.out.println("Lookup by ID:");
        System.out.println("lookup(1) -> " + userLookup.lookup(1));
        System.out.println("lookup(2) -> " + userLookup.lookup(2));
        System.out.println("lookup(4) -> " + userLookup.lookup(4));

        System.out.println("\nLookup by Name:");
        System.out.println("lookup(\"John\") -> " + userLookup.lookup("John"));
        System.out.println("lookup(\"Alice\") -> " + userLookup.lookup("Alice"));
        System.out.println("lookup(\"Charlie\") -> " + userLookup.lookup("Charlie"));

        System.out.println("\nLookup by Email:");
        System.out.println("lookup(\"john@john.com\") -> " + userLookup.lookup("john@john.com"));
        System.out.println("lookup(\"alice@gmail.org\") -> " + userLookup.lookup("alice@gmail.org"));
        System.out.println("lookup(\"invalid@gmail.com\") -> " + userLookup.lookup("invalid@gmail.com"));
    }
}