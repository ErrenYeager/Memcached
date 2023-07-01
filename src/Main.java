public class Main {
    public static void main(String[] args) {
        Memcached memcached = new Memcached(100, 10, 10, 5);

        // Inserting values into the cache
        // TODO: ADD TTL
        memcached.put("key1", "value1");
        memcached.put("key2", "value2");
        memcached.put("key3", "value3");

        // Retrieving values from the cache
        System.out.println(memcached.get("key1")); // Output: value1
        System.out.println(memcached.get("key2")); // Output: value2
        System.out.println(memcached.get("key3")); // Output: value3
        System.out.println(memcached.get("key4")); // Output: null
    }
}
