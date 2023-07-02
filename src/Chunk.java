public class Chunk {
    private Object value;

    public Chunk(Object value) {
        this.value = value;
    }
    public Chunk() {
        value = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isFull() {
        return value == null;
    }
}
