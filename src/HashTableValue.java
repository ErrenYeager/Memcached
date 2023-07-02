public class HashTableValue {

    private int slabAddress;
    private int chunkAddress;

    public HashTableValue(int slabAddress, int chunkAddress) {
        this.slabAddress = slabAddress;
        this.chunkAddress = chunkAddress;
    }

    public int getSlabAddress() {
        return slabAddress;
    }

    public void setSlabAddress(int slabAddress) {
        this.slabAddress = slabAddress;
    }

    public int getChunkAddress() {
        return chunkAddress;
    }

    public void setChunkAddress(int chunkAddress) {
        this.chunkAddress = chunkAddress;
    }
}
