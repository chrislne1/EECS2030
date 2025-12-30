package model;

public class Projection extends BinarySeqOperation {
    private int[] result;

    public Projection(int[] a, int[] b) {
        super(a, b);
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    count++;
                    break;
                }
            }
        }
        result = new int[count];
        int k = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    result[k++] = b[i];
                    break;
                }
            }
        }
    }

    public boolean isSequence() { return true; }
    public int[] getSequence() { return result; }

    public String toString() {
        return "Projecting " + arr(a) + " to " + arr(b) + " results in: " + arr(result);
    }

    private String arr(int[] x) {
        if (x == null || x.length == 0) return "[]";
        String s = "[";
        for (int i = 0; i < x.length; i++) {
            s += x[i];
            if (i < x.length - 1) s += ", ";
        }
        return s + "]";
    }
}
