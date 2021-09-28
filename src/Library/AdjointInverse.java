package Library;

import static Library.CofactorDeterminant.*;
import matriks.Matriks;

public class AdjointInverse {
    public static void getInverse(Matriks m) {
        double det = getDeterminant(m);
        if (det == 0) {
            System.out.println("Matriks tidak memiliki inverse. (Determinan = 0)");
        }
        else {
            Matriks mk = multiplyMatrix(m, 1/det);
            System.out.println("Inverse Matriks: ");
            mk.displayMatriks();
        }
    }

    public static Matriks multiplyMatrix(Matriks m, double k) {
        int i,j;
        int N = m.baris;
        Matriks mk = new Matriks(N, N);
        for (i=0; i<N; i++) {
            for (j=0; j<N; j++) {
                mk.ELMT[i][j] = mk.ELMT[i][j] * k;
            }
        }
        return mk;
    }

}
