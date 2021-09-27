package Library;

import java.util.Scanner;

public class InOut {
    
//    public static void main(String[] args) {
//        Matriks m1 = readMatrix();
//        displayMatrix(m1);
//    }

    public static Matriks readMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris: ");
        int nBrs = input.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        int nKol = input.nextInt();

        Matriks m = new Matriks (nBrs, nKol);
        for (int i = 0; i < nBrs; i++) {
            for (int j = 0; j < nKol; j++) {
                m.ELMT[i][j] = input.nextDouble();
            }
        }
        input.close();
        return m;
    }

    public static Matriks readSquareMatrix() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ukuran matriks: ");
        int N = input.nextInt();

        Matriks m = new Matriks (N, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m.ELMT[i][j] = input.nextDouble();
            }
        }
        input.close();
        return m;
    }

    public static void displayMatrix(Matriks m) {
        for (int i=0; i<m.baris; i++) {
            for (int j=0; j<m.kolom; j++)
            {
                System.out.printf("%.2f ", m.ELMT[i][j]);
            }
            System.out.print("\n");
        }
    }

    // dipanggil di method solution
    public static void displaySPLSolution(double[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %.3f\n",i+1, result[i]);
        }
    }

    public static void displaySPLSolution(String[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %s\n", i+1, result[i]);
        }
    }

    public static void displayDeterminant(double[] det) {
        System.out.printf("Determinan = %.3f", det);
    }

}