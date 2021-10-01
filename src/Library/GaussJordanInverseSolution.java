package Library;

import matriks.Matriks;

public class GaussJordanInverseSolution {
    public static void jordanInverseSolution(Matriks m) {
        Matriks n = new Matriks(m.baris, m.kolom);
        for (int i=0;i<n.baris;i++)
        {
            for (int j=0;j<n.kolom;j++)
            {
                n.ELMT[i][j] = m.ELMT[i][j];
            }
        }
        double det = GaussDeterminant.gaussDeterminant(m);
        
        if (det == 0) {
            System.out.println("Matriks tidak memiliki inverse. (Determinan = 0)");
        } else {
            n = GaussJordanInverse.makeInverse(n);
            System.out.println("Inverse Matriks: ");
            n.displayMatriks();
        }
    }
    
}
