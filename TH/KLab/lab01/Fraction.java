public class Fraction {
    private int numer;
    private int denom;

    public Fraction() {
        numer = 0;
        denom = 1;
    }
    public Fraction (int x, int y) {
        numer = x;
        denom = y;
    }
    public Fraction (Fraction f) {
        this.numer = f.numer;
        this.denom = f.denom;
    }
    public String toString() {
        return numer + "/" + denom;
    }
    public boolean equals (Object f) {
        if(f instanceof Fraction) {
            Fraction tmp = (Fraction) f;
            if (numer == tmp.numer && denom == tmp.denom)   return true;
            return false;
        }
        return false;
    }
}
