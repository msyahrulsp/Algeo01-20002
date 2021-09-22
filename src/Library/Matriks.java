package Library;

public class Matriks {
    public int baris, kolom, idxBrs, idxKol, nSol;
    public double[][] ELMT;

    // Konstruktor
    public Matriks(double[][] ELMT, int baris, int kolom) {
        this.ELMT = ELMT;
        this.baris = baris;
        this.kolom = kolom;
    }

    public static int add(int a, int b) { // ini methodnya
        return a + b + a + b;
    }
}
