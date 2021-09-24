package Library;

// Prekondisi : matriks nBrsxnKol dengan m.kolom = m.baris+!
//              banyak variabel = m.baris

public class GaussSolution {

    public static void gaussSolution(Matriks m) {

        GaussElimination.gaussElimination(m);
        if (isNoSolution(m)) {
            System.out.println("Sistem persamaan linear ini tidak memiliki solusi");
        }
        else if (isInfinitySolutions(m)) {
            System.out.println("Sistem persamaan linear ini memiliki sebanyak tak hingga solusi");
        }
        else {
            double[] result = isOneSolution(m);
            System.out.println("Sistem persamaan linear ini memiliki 1 solusi unik, yaitu:");
            InOut.displaySPLSolution(result);
        }
    }

    public static boolean isNoSolution (Matriks m) {
        boolean noSolution = false;
        boolean isPartial0 = true;
        int i = m.baris-1;
        while (i>=0 && !noSolution) {
            int j = 0;
            while (j<m.kolom-1 && isPartial0) {
                isPartial0 = (m.ELMT[i][j] == 0);
                j++;
            }
            noSolution = (isPartial0) && (m.ELMT[i][m.kolom-1] != 0);
            i--;
        }
        return noSolution;
    }

    public static boolean isInfinitySolutions(Matriks m) {
        return GaussElimination.allElmtBrsIs0(m, m.baris-1);
    }

    public static double[] isOneSolution(Matriks m) {
        // back substituion
        double[] result = new double[m.kolom-1];
        for(int i=m.kolom-2; i>=0; i--) {
            result[i] = m.ELMT[i][m.kolom-1];
            for(int j=i+1; j<m.kolom-1; j++) {
                result[i] -= m.ELMT[i][j]*result[j];
            }
        }
        return result;
    }
}
