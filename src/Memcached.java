import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Memcached {
    private Map<String, Chunk> cache;
    private LinkedList<String> lru;
    private Map<Integer, Slab> slabs;
    private int slabSize;
    private int maxCacheSize;

    public Memcached(int maxCacheSize, int slabSize, int initialSlabs, int initialChunksPerSlab) {
        cache = new HashMap<>();
        lru = new LinkedList<>();
        slabs = new HashMap<>();
        this.maxCacheSize = maxCacheSize;
        this.slabSize = slabSize;

        for (int i = 0; i < initialSlabs; i++) {
            slabs.put(i, new Slab(slabSize, initialChunksPerSlab));
        }
    }

    public Object get(String key) {
        int keyOfHashTable = key.hashCode() % cache.size();
        if (cache.containsKey(keyOfHashTable)) {
            lru.remove(key);
            lru.addFirst(key);
            return cache.get(key).getValue();
        }
        return null;
    }

    public void put(String key, Object value) {
        if (cache.size() >= maxCacheSize) {
            String removedKey = lru.removeLast();
            cache.remove(removedKey);
        }

        int keyOfHashTable = key.hashCode() % cache.size();
        Slab selectedSlab = selectSlab(getSize(value));

        if (selectedSlab.hasAvailableChunk()) {
            Chunk chunk = selectedSlab.getAvailableChunk();
            chunk.setUsed(chunk.getUsed() + 1);
            slab.getValues().put(key, value);
            lru.addFirst(key);
        } else {
            // Create a new slab and chunk
            Slab newSlab = new Slab(slabSize, 1);
            Chunk newChunk = newSlab.getAvailableChunk();
            newChunk.setUsed(newChunk.getUsed() + 1);
            newSlab.getValues().put(key, value);
            lru.addFirst(key);
            slabs.put(slabIndex, newSlab);
        }

        // Store slab reference in the cache
        cache.put(key, slab);
    }

    public Slab getSlab(String key) {
        return cache.get(key);
    }

    public Slab selectSlab(int size){
        double minDiff = Double.MAX_VALUE;
        int nearest = 0;
        for (int key : slabs.keySet()) {
            double diff = Math.abs((double) size - (double) key);
            if (diff < minDiff) {
                nearest = key;
                minDiff = diff;
            }
        }

        return nearest == 0 ? null : slabs.get(nearest);
    }
}