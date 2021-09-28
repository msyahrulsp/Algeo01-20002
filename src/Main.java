//import Library.Matriks;

import Library.Matriks;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        // System.out.println(add(1,2)); // contoh call fungsi library nya
        // Matriks TestMatriks = new Matriks(10,10);
        // System.out.println("nBaris nKolom: " + TestMatriks.baris + TestMatriks.kolom);
        Matriks A = new Matriks();
        A.fileInput("1a.txt");
        A.displayMatriks();
    }
}

//disini kode2