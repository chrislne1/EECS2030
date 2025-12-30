package model;

public abstract class BinarySeqOperation implements SeqOperation {
    protected int[] a;
    protected int[] b;

    protected BinarySeqOperation(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public boolean isBoolean() { return false; }
    public boolean isSequence() { return false; }
    public int[] getSequence() { return null; }
    public boolean getBoolean() { return false; }
}
