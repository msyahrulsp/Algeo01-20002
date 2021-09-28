package Library;
import static Library.CofactorDeterminant.*;



public class TransposeCofactorAdjoint {
    public static Matriks getTranspose(Matriks m) {
        Matriks mTranspose = new Matriks(m.kolom, m.baris);
        for (int i=0; i<mTranspose.baris; i++) {
            for (int j=0; j<mTranspose.kolom; j++) {
                mTranspose.ELMT[i][j] = m.ELMT[j][i];
            }
        }
        return mTranspose;
    }

    public static Matriks getCofactor(Matriks m) {
        int N = m.baris;
        Matriks mCofactor = new Matriks(N, N);
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                double detMinor = getDeterminant(getMinor(m, i, j));
                mCofactor.ELMT[i][j] = Math.pow(-1, (i+j))*detMinor;
            }
        }
        return mCofactor;
    }

    public static Matriks getAdjoint(Matriks m) {
        return getTranspose(getCofactor(m));
    }
}
