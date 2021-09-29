package Library;

import static Library.CofactorDeterminant.*;
import static Library.TransposeCofactorAdjoint.*;
import matriks.Matriks;

public class AdjointInverse {
    public static void getInverse(Matriks m) {
        double det = getDeterminant(m);
        if (det == 0) {
            System.out.println("Matriks tidak memiliki inverse. (Determinan = 0)");
        }
        else {
            Matriks adj = getAdjoint(m);
            Matriks mk = multiplyMatrix(adj, 1/det);
            System.out.println("Inverse Matriks: ");
            mk.displayMatriks();
        }
    }

    public static Matriks multiplyMatrix(Matriks m, double k) {
        int i, j;
        Matriks mk = Matriks.copyMatriks(m, m.baris, m.kolom);
        for (i = 0; i < m.baris; i++) {
            for (j = 0; j < m.baris; j++) {
                mk.ELMT[i][j] *= k;
            }
        }
        return mk;
    }

    public static Matriks getResult(Matriks m) {
        double det = getDeterminant(m);
        if (det == 0) {;
            return(new Matriks(0, 0));
        }
        else {
            Matriks adj = getAdjoint(m);
            Matriks mk = multiplyMatrix(adj, 1/det);
            return mk;
        }
    }

}
