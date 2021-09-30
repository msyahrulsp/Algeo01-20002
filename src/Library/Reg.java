package Library;

import matriks.Matriks;
import java.util.Scanner;

public class Reg {
    public static void getSolution(Matriks m) {
        Matriks reg = Reg.getMatriks(m);
        Matriks gReg = Matriks.copyMatriks(reg, reg.baris, reg.kolom);
        GaussJordanElimination.gaussJordanElimination(gReg);

        if (GaussJordanSolution.isInfinitySolutions(gReg)) {
            System.out.println("Tidak bisa ditaksir karena mempunyai solusi ganda");
        } else if (GaussJordanSolution.isNoSolution(gReg)) {
            System.out.println("Tidak mempunyai solusi");
        } else {
            gReg.displayMatriks();
            double[] res = Matriks.getDSolution(gReg);
            displayEquation(reg);

            System.out.println("Hasil");
            for (int i = 0; i < res.length; i++) {
                System.out.printf("b%d = %.4f\n", i, res[i]);
            }

            double tak = 0;
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    tak += res[i];
                } else {
                    System.out.printf("Masukkan x%d = ", i);
                    tak += res[i] * scanner.nextDouble();
                }
            }
            System.out.printf("\nHasil taksiran\n%.4f", tak);
        }
    }

    private static Matriks getMatriks(Matriks m) {
        Matriks res = new Matriks(m.kolom, m.kolom + 1);
        
        // i j di reverse karena oRkOM
        for (int i = 0; i < res.kolom; i++) {
            for (int j = 0; j < res.baris; j++) {
                res.ELMT[j][i] = 0;
                for (int k = 0; k < m.baris; k++) {
                    if ((i == 0) && (j == 0)) {
                        res.ELMT[j][i] = m.baris;
                    } else if (j == 0) {
                        res.ELMT[j][i] += m.ELMT[k][i - 1];
                    } else if (i == 0) {
                        res.ELMT[j][i] += m.ELMT[k][j - 1];
                    } else {
                        res.ELMT[j][i] += m.ELMT[k][i - 1] * m.ELMT[k][j - 1];
                    }
                    
                }
            }
        }
        
        return res;
    }

    private static void displayEquation(Matriks m) {
        for (int i = 0; i < m.baris; i++) {
            for (int j = 0; j < m.kolom; j++) {
                System.out.printf("%.3f", m.ELMT[i][j]);
                if (j < m.kolom - 1) System.out.printf("b%d ", j);
                if (j < m.kolom - 2) System.out.print("+ ");
                if (j == m.kolom - 2) System.out.printf("= ", j);
            }
            if (i < m.baris) System.out.print("\n");
        }
    }
}
