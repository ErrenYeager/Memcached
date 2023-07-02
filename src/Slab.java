import java.util.LinkedList;

public class Slab {
    private int chunkSize;
    private LinkedList<Chunk> chunks;

    public Slab(int chunkSize, int initialChunks) {
        this.chunkSize = chunkSize;
        this.chunks = new LinkedList<>();

        for (int i = 0; i < initialChunks; i++) {
            chunks.add(new Chunk());
        }
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public LinkedList<Chunk> getChunks() {
        return chunks;
    }

    public void setChunks(LinkedList<Chunk> chunks) {
        this.chunks = chunks;
    }

    public int getLeastUsedItemIndex() {
        // TODO: 7/2/23
        int index = 0;
        return index;
    }

    public int getAvailableChunk() {
        for (int i = 0; i < chunks.size(); i++) {
            if (!chunks.get(i).isFull()) {
                return i;
            }
        }
        return getLeastUsedItemIndex();
    }
}
