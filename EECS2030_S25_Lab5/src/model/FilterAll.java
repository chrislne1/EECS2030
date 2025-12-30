package model;

public class FilterAll extends SeqEvaluator {
    public FilterAll(int c) {
        super(c);
    }

    public String toString() {
        int bad = 0;
        for (int i = 0; i < size; i++) {
            if (!ops[i].isBoolean()) bad++;
        }
        if (bad > 0) {
            return "Filter cannot be evaluated due to " + bad + " incompatile operations.";
        }

        String s = "Filter result is: ";
        for (int i = 0; i < size; i++) {
            boolean v = ops[i].getBoolean();
            if (v) s += "true";
            else s += "_";
            if (i < size - 1) s += ", ";
        }
        return s;
    }
}
