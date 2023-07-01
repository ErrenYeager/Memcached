import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Slab {
    private int chunkSize;
    private LinkedList<Chunk> chunks;

    public Slab(int chunkSize, int initialChunks) {
        this.chunkSize = chunkSize;
        this.chunks = new LinkedList<>();

        for (int i = 0; i < initialChunks; i++) {
            chunks.add(new Chunk(chunkSize));
        }
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public LinkedList<Chunk> getChunks() {
        return chunks;
    }

    public Object getValue(String key) {
        for (Chunk chunk : chunks) {

        }
    }

    public boolean hasAvailableChunk() {
        for (Chunk chunk : chunks) {
            if (!chunk.isFull()) {
                return true;
            }
        }
        return false;
    }

    public Chunk getAvailableChunk() {
        for (Chunk chunk : chunks) {
            if (!chunk.isFull()) {
                return chunk;
            }
        }
        return null;
    }
}