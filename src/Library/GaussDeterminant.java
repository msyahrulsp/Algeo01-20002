package Library;
import static Library.GaussElimination.*;

public class GaussDeterminant {

    public static double gaussDeterminant(Matriks m) {
        gaussElimination(m);
        int swapCount = GaussElimination.swapCount;
        double constant = GaussElimination.constant;
        double det = Math.pow(-1,swapCount) / constant;
        for (int i=0; i<m.baris; i++) {
            det *= m.ELMT[i][i];
        }
        return det;
    }
}
