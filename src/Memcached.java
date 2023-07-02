import java.util.ArrayList;

public class Memcached {
    private ArrayList<Slab> slabs;
    //todo: what if hashtable gets full
    private HashTableValue[] hashTable;
    private final int hashtableSize;

    public Memcached(int maxCacheSize) {
        this.hashtableSize = maxCacheSize;
    }

    public void put(Item newItem) {
        int indexOfHashTable = newItem.hashCode() % hashtableSize;
        int slabAddress = findTheAppropriateSlab(newItem.getSize());
        int chunkAddress = slabs.get(slabAddress).getAvailableChunk();
        HashTableValue hashTableValue = new HashTableValue(slabAddress, chunkAddress);
        hashTable[indexOfHashTable] = hashTableValue;
        //todo: save the data in the memory
    }

    public void get(String key) {
        int indexOfHashTable = key.hashCode() % hashtableSize;
        if (hashTable[indexOfHashTable] != null) {
            // TODO: 7/2/23
//            lru.remove(key);
//            lru.addFirst(key);
//            return cache.get(key).getValue();
        }
//        return null;
    }

    public int findTheAppropriateSlab(int itemSize) {
        int minDiff = Integer.MAX_VALUE;
        int nearest = 0;
        for (int i = 0; i < slabs.size(); i++) {
            int diff = Math.abs(itemSize - slabs.get(i).getChunkSize());
            if (diff < minDiff) {
                nearest = i;
                minDiff = diff;
            }
        }
        return nearest;
    }


}
