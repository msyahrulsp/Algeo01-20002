package Library;

import java.util.Scanner;
import static Library.GaussSolution.*;
import static Library.GaussElimination.*;
import matriks.Matriks;

public class InterpolasiPolinom {

    public static Matriks readPolinom ()

    {
        int i, j;
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah n: ");
        int n = input.nextInt();

        Matriks m = new Matriks (n, 2);
        System.out.println("Masukkan pasangan titik-titik: ");
        for (i=0;i<n;i++)
        {
            for (j=0;j<2;j++)
            {
                m.ELMT[i][j] = input.nextDouble();
            }


        }
        return m;
        // masukkan point ke sistem persamaan lanjar
        // gunakan gauss untuk mendapatkan a0, a1 ... an-1 (dlm bentuk matriks)
        // masukkan a0 .. an-1 ke sistem persamaan lanjar
        // diberikan x untuk didapatkan hasil f(x) = ... ?
    }

    public static double readX() {
        System.out.println("Masukkan nilai x yang akan ditaksir: ");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();

        // input.close();
        return x;
    }

    public static Matriks makePolinom(Matriks m)
    {
        int i, j;
        int nBrs = m.baris;
        Matriks n = new Matriks(nBrs, nBrs+1);

        for (i=0;i<nBrs;i++)
        {
            for (j=0;j<nBrs;j++)
            {
                // operasi pangkat polinom kuadratik
                n.ELMT[i][j] = Math.pow(m.ELMT[i][0], j); 
            }
            n.ELMT[i][nBrs] = m.ELMT[i][1];
        }
        return n;
    }

    public static void polinomSolution(Matriks m, double x) {
        
        double taksirResult = 0;
        Matriks o = m;
        GaussJordanElimination.gaussJordanElimination(o);
        double[] result = isOneSolution(o);

        System.out.print("Penyelesaian sistem persamaan dengan metode eliminasi Gauss menghasilkan: ");
        System.out.println("");
        for (int i=0;i<result.length-1;i++) {
            System.out.format("a%d = %.4E, ", i, result[i]);
        }
        System.out.format("a%d = %.4E.\n ", result.length-1, result[result.length-1]);
        System.out.println("");
        System.out.format("Polinom interpolasi yang melalui %d buah titik tersebut adalah p%d(x) =", result.length, result.length-1);
        System.out.println("");
        for (int i=0;i<result.length-1;i++) {
            System.out.format(" %.4Ex^%d +", result[i], i);
        }
        System.out.format(" %.4E^%d.\n", result[result.length-1], result.length-1);
        System.out.println("");

        // menghitung nilai hasil taksiran dari polinom
        for (int i=0;i<result.length;i++) {
            taksirResult += result[i] * Math.pow(x, i);
        }

        System.out.format("Dengan menggunakan polinom ini, maka nilai fungsi pada x = %.3f \ndapat ditaksir menghasilkan p%d(%.3f) = %f", x, result.length-1, x, taksirResult);
    }

    public static void displaySPLSolution(double[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %.4f\n",i+1, result[i]);
        }
    }

}
