package Library;

// import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

public class Matriks {
    public int baris, kolom, idxBrs, idxKol, nSol;
    public double[][] ELMT;

    // Konstruktor
    public Matriks(int baris, int kolom) {
        this.ELMT = new double[baris][kolom];
        this.baris = baris;
        this.kolom = kolom;
    }

    public static int add(int a, int b) { // ini methodnya
        return a + b + a + b;
    }
}
