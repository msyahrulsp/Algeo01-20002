package Library;

import matriks.Matriks;

public class Crammer {
    public static void getSolution(Matriks m) {
        if (m.baris != m.kolom - 1) {
            System.out.println("Matriks Base Crammer harus NxN");
        } else {
            double[] res = new double[m.baris];
            Matriks base = Matriks.copyMatriks(m, m.baris, m.kolom - 1);
            Matriks baseB = Matriks.getMSolution(m);
            double det = CofactorDeterminant.getDeterminant(base);
            if (det == 0) {
                System.out.println("Tidak ada solusi");
            } else {
                Matriks temp = base;
                for (int i = 0; i < m.baris; i++) {
                    temp = Matriks.changeRow(temp, baseB, i);
                    res[i] = CofactorDeterminant.getDeterminant(temp) / det;
                    temp = Matriks.copyMatriks(m, m.baris, m.kolom - 1);
                }
                Matriks.displaySPLSolution(res);
            }
        }
        
    }
}
