package model;

public class OccursWithin extends BinarySeqOperation {
    private boolean occurs;

    public OccursWithin(int[] a, int[] b) {
        super(a, b);
        if (a.length == 0) {
            occurs = true;
            return;
        }
        if (b.length < a.length) {
            occurs = false;
            return;
        }
        for (int i = 0; i <= b.length - a.length; i++) {
            boolean match = true;
            for (int j = 0; j < a.length; j++) {
                if (b[i + j] != a[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                occurs = true;
                return;
            }
        }
        occurs = false;
    }

    public boolean isBoolean() { return true; }
    public boolean getBoolean() { return occurs; }

    public String toString() {
        if (occurs)
            return arr(a) + " occurs within " + arr(b);
        return arr(a) + " does not occur within " + arr(b);
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
