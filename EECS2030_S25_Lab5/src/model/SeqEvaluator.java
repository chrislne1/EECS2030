package model;

public abstract class SeqEvaluator {
    protected SeqOperation[] ops;
    protected int size;

    public SeqEvaluator(int capacity) {
        ops = new SeqOperation[capacity];
        size = 0;
    }

    public void addOperation(String name, int[] a, int[] b) throws IllegalOperationException {
        SeqOperation op;
        if (name.equals("op:projection")) {
            op = new Projection(a, b);
        } else if (name.equals("op:occursWithin")) {
            op = new OccursWithin(a, b);
        } else if (name.equals("op:sumsOfPrefixes")) {
            op = new SumsOfPrefixes(a);
        } else {
            throw new IllegalOperationException();
        }
        ops[size++] = op;
    }

    public abstract String toString();
}
