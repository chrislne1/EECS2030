package model;

public class SumsOfPrefixes implements SeqOperation {
    private int[] a;
    private int[] result;

    public SumsOfPrefixes(int[] a) {
        this.a = a;
        result = new int[a.length + 1];
        int sum = 0;
        result[0] = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            result[i + 1] = sum;
        }
    }

    public boolean isSequence() { return true; }
    public boolean isBoolean() { return false; }
    public int[] getSequence() { return result; }
    public boolean getBoolean() { return false; }

    public String toString() {
        return "Sums of prefixes of " + arr(a) + " is: " + arr(result);
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
