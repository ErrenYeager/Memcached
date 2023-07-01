public class Main {
    public static void main(String[] args) {
        MemoryPool memoryPool = new MemoryPool();
        memoryPool.addSlabClass(64); // Add slab class for item size of 64 bytes

        // Allocate chunks for items
        Chunk chunk1 = memoryPool.allocateChunk(64, "Item 1");
        Chunk chunk2 = memoryPool.allocateChunk(64, "Item 2");

        // Retrieve stored items from chunks
        if (chunk1 != null) {
            System.out.println("Item 1: " + chunk1.getItem());
        }
        if (chunk2 != null) {
            System.out.println("Item 2: " + chunk2.getItem());
        }
    }
}