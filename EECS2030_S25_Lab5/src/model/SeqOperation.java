package model;

public interface SeqOperation {
    boolean isSequence();
    boolean isBoolean();
    int[] getSequence();
    boolean getBoolean();
    String toString();
}
