package Library;

import matriks.Matriks;
import java.util.Scanner;

public class Reg {
    public static void getSolution(Matriks m, double[] taksir) {
        Matriks reg = Reg.getMatriks(m);
        Matriks gReg = Matriks.copyMatriks(reg, reg.baris, reg.kolom);
        GaussJordanElimination.gaussJordanElimination(gReg);

        if (GaussJordanSolution.isInfinitySolutions(gReg)) {
            System.out.println("Tidak bisa ditaksir karena mempunyai solusi ganda");
        } else if (GaussJordanSolution.isNoSolution(gReg)) {
            System.out.println("Tidak mempunyai solusi");
        } else {
            System.out.println("Persamaan yang didapatkan");
            double[] res = Matriks.getDSolution(gReg);
            displayEquation(reg);

            System.out.println("\nHasil");
            for (int i = 0; i < res.length; i++) {
                System.out.printf("b%d = %.4f\n", i, res[i]);
            }

            System.out.println("\nPentaksiran");
            double tak = 0;
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    tak += res[i];
                } else {
                    System.out.printf("x%d = %.2f\n", i, taksir[i - 1]);
                    tak += res[i] * taksir[i - 1];
                }
            }
            System.out.printf("\nHasil taksiran\n%.4f\n", tak);
        }
    }

    public static double[] getTaksiran(Matriks m) {
        double[] t = new double[m.kolom - 1];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < t.length; i ++) {
            System.out.printf("Masukkan x%d = ", i);
            t[i] = scanner.nextDouble();
        }
        return t;
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
