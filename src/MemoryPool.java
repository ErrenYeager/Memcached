import java.util.HashMap;
import java.util.Map;

class MemoryPool {
    public static final int PAGE_SIZE = 4096; // Size of each memory page in bytes
    private Map<Integer, Slab> slabClasses; // Mapping of item size to corresponding slab

    public MemoryPool() {
        this.slabClasses = new HashMap<>();
    }

    public void addSlabClass(int itemSize) {
        if (slabClasses.containsKey(itemSize)) {
            return; // Slab class already exists for this item size
        }

        int chunkSize = itemSize + 4; // Additional 4 bytes for metadata
        Slab slab = new Slab(chunkSize);
        slabClasses.put(itemSize, slab);
    }

    public Chunk allocateChunk(int itemSize, Object item) {
        Slab slab = slabClasses.get(itemSize);
        if (slab == null || slab.isFull()) {
            return null; // No slab available for this item size or slab is full
        }

        return slab.allocateChunk(item);
    }
}