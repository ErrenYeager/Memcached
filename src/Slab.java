import java.util.*;



class Slab {
    private int chunkSize; // Size of each chunk in bytes
    private List<Chunk> chunks; // List of chunks within the slab

    public Slab(int chunkSize) {
        this.chunkSize = chunkSize;
        this.chunks = new ArrayList<>();
    }

    public boolean isFull() {
        return chunks.size() == getMaxChunks();
    }

    public int getMaxChunks() {
        return MemoryPool.PAGE_SIZE / chunkSize;
    }

    public Chunk allocateChunk(Object item) {
        if (isFull()) {
            return null; // No available chunk in this slab
        }

        Chunk chunk = new Chunk(item);
        chunks.add(chunk);
        return chunk;
    }
}

