package Library;

public class CofactorDeterminant {
    public static double getDeterminant(Matriks m) {
        int N = m.baris;
        double det;
        if (N == 1) {
            det = m.ELMT[0][0];
        }
        else if (N == 2) {
            det = m.ELMT[0][0]*m.ELMT[1][1] - m.ELMT[1][0]*m.ELMT[0][1];
        }
        else {
            det = 0;
            for (int i=0; i<N; i++) {
                det += Math.pow(-1, i) * m.ELMT[0][i] * getDeterminant(getMinor(m, 0, i));
            }
        }
        return det;
    }
    public static Matriks getMinor(Matriks m, int x, int y) {
        int N = m.baris;
        Matriks mMinor = new Matriks(N-1, N-1);
        int minorBrs, minorKol;

        minorBrs = 0;
        for (int i = 0; i < N; i++) {
            if (i == x) {
                continue;
            }
            else {
                minorKol = 0;
                for (int j = 0; j < N; j++) {
                    if (j == y) {
                        continue;
                    } else {
                        mMinor.ELMT[minorBrs][minorKol] = m.ELMT[i][j];
                        minorKol++;
                    }
                }
                minorBrs++;
            }
        }
        return mMinor;
    }
}
