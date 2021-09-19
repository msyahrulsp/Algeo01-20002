//import Library.Matriks;

import Library.Matriks;

import static Library.Matriks.add; // import from library located in .jar file

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(add(1,2)); // contoh call fungsi library nya
        Matriks TestMatriks = new Matriks(10,10);
        System.out.println("nBaris nKolom: " + TestMatriks.baris + TestMatriks.kolom);
    }
}

//disini kode2