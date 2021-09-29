package Library;

import matriks.Matriks;

public class InverseSolution {
    public Matriks mInverse, mB;

    public static void getISolution(Matriks mInverse, Matriks mB) {
        double[] res = multiply(mInverse, mB);
        Matriks.displaySPLSolution(res);
    }

    private static double[] multiply(Matriks m1, Matriks m2) {
        int temp = 0;
        double[] res = new double[m1.baris];

        for (int i = 0; i < m1.baris; i++) {
            for (int j = 0; j < m2.kolom; j++) {
                temp = 0;
                for (int k = 0; k < m1.kolom; k++) {
                    temp += m1.ELMT[i][k] * m2.ELMT[k][j]; 
                }
            }
            res[i] = temp;
        }
        return res;
    }
}
