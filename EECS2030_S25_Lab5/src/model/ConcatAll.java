package model;

public class ConcatAll extends SeqEvaluator {
    public ConcatAll(int c) {
        super(c);
    }

    public String toString() {
        int bad = 0;
        for (int i = 0; i < size; i++) {
            if (!ops[i].isSequence()) bad++;
        }
        if (bad > 0) {
            return "Concat cannot be evaluated due to " + bad + " incompatile operations.";
        }

        int total = 0;
        for (int i = 0; i < size; i++) {
            total += ops[i].getSequence().length;
        }
        int[] out = new int[total];
        int k = 0;
        String s = "Concat(";
        for (int i = 0; i < size; i++) {
            int[] r = ops[i].getSequence();
            s += arr(r);
            if (i < size - 1) s += ", ";
            for (int j = 0; j < r.length; j++) out[k++] = r[j];
        }
        s += ") = " + arr(out);
        return s;
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
